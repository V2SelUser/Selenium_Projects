/*
 * WebLab support.
 */

var cookieName = 'experiment';
var domain = '.amazon.com';

module.requireAll('smash/cookie', 'smash/message').spread(function(cookies, messages) {


    var contract = 'com.amazon.mash.weblab';

    // Read the experiment cookie and parse it into an object.
    function parse() {
        var cookie = cookies.get(cookieName);
        var weblabs = cookie ? cookie.split('&') : [];
        var treatments = {};

        for (var i = 0; i < weblabs.length; i++) {
            var parts = weblabs[i].split(':');
            treatments[parts[0]] = parts[1];
        }

        return treatments;
    }

    // Write all overwrites back into the cookie.
    function save(treatments) {
        var arr = [];
        for (var n in treatments) {
            arr.push(n + ':' + treatments[n]);
        }
        var cookie = arr.join('&');
        cookies.set(cookieName, cookie, {domain: domain});
    }

    function Weblab(name) {
        this.name = name;
    }

    Weblab.prototype.recordTrigger = function() {
        var message = messages.obtainMessage(contract, 'recordTrigger', {name:this.name});
        return messages.sendMessage(message);
    }

    Weblab.prototype.getTreatmentAssignment = function() {
        console.log('getting treatment');
        var message = messages.obtainMessage(contract, 'getTreatmentAssignment', {name:this.name});
        return messages.postMessage(message).then(function(message) {
            return message.treatment;
        });
    }

    Weblab.prototype.getTreatmentAndRecordTrigger = function() {
        var message = messages.obtainMessage(contract, 'getTreatmentAndRecordTrigger', {name:this.name});
        return messages.postMessage(message).then(function(message) {
            return message.treatment;
        });
    }

    module.register({
        version : 1,

        /* Override a weblab to deliver the specified treatment.
         */
        override : function(name, treatment) {
            var weblabs = parse();
            weblabs[name] = treatment;
            save(weblabs);
        },

        /* Remove a specific treatment override.
         */
        remove : function(name) {
            var weblabs = parse();
            delete weblabs[name];
            save(weblabs);
        },

        /* Gets a native weblab
         */
        get : function(name) {
            return new Weblab(name);
        }
    });

});

