/*
 * MASH Navigator
 */

module.require('smash/message').then(function(messages) {

    var contract = 'com.amazon.mash.navigate';

    module.register({
        version : 1,

        open : function(url) {
            var message = messages.obtainMessage(contract, 'open', {targetUrl:url});
            return messages.postMessage(message);
        }
    });
});

