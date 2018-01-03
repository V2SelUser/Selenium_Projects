/*
 * MASH Message Service
 */

var nextIdentifier = Math.floor((Math.random() * 1000) + 1);

function generateIdentifier() {
    return nextIdentifier++;
}

module.register({
    version : 2,

    /*
     * Returns a new message.
     */
    obtainMessage : function(contract, topic, data) {
        var d = data || {};
        if (!(typeof d === 'object')) {
            throw Error('Message payload is not an object');
        }

        d._type = Type.make(contract, topic);
        return d;
    },

    /*
     * Sends the specified message.
     */
    sendMessage : function(message) {
        pending.push(message);
        drainLater();
    },

    /*
     * Makes the messages replyable and wraps it into a promise. You still have to call
     * sendMessage() (after calling this method).
     */
    promisify : function(message) {
        var id = generateIdentifier();
        var responseContract = '#' + id;
        message._replyTo = Type.make(responseContract, 'response');

        return new Promise(function(resolve, reject) {
            var subscription = module.subscribe(responseContract, function(response) {
                if (response._error === undefined) {
                    resolve(response);
                } else {
                    var message = response._error.message;
                    var e = Error(message);
                    e.javaStack = response._error.stack;
                    reject(e);
                }
                subscription.unsubscribe();
            });
        });
    },

    /*
     * Sends a replyable message and returns a promise.
     */
    postMessage : function(message) {
        var promise = this.promisify(message);
        this.sendMessage(message);
        return promise;
    },

    /*
     * Builds a subscription for lifecycle event callbacks
     * Any callback function the caller wishes to implement must be a function of the events parameter.
     * If events includes an 'unhandled' function, this will be called with any events that were not handled.
     * AutoUnsub is a boolean parameter which indicates if the subscription should be automatically
     * unsubscribed after the first event callback.  Regardless of autoUnsub, an unsubscribe function
     * will be added to events which will unsubscribe this subscription.
     */
    subscribeLifecycleEvents : function(events, autoUnsub) {
        events = events || {};
        var id = generateIdentifier();
        var responseContract = '#' + id;

        var subscription = module.subscribe(responseContract, function(response) {
            var topic = new Type(response._type).topic();
            var callback = events[topic];
            if (callback == undefined || !isFunction(callback)) {
                if (events.unhandled != undefined && isFunction(events.unhandled)) {
                    events.unhandled(topic);
                } else {
                    // swallow return call
                }
            } else {
                callback();
            }
            if (autoUnsub) {
                subscription.unsubscribe();
            }
        });

        events.unsubscribe = function() {
            subscription.unsubscribe();
        }

        return responseContract;
    }
});
