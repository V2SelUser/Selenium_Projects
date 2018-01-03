/*
 * MASH Metric Service
 */

module.require('smash/message').then(function(messages) {

    var contract = 'com.amazon.mash.metric';

    module.register({
        version : 1,

        /*
         * Sends a metrics event.
         *
         * {
         *   service: 'service name',
         *   method: 'method name',
         *   metricClass: 'class name',
         *   instance: 'instance',
         *   value: 'value',
         *   timer: 12.34
         * }
         */
        send : function(event) {
            var message = messages.obtainMessage(contract, 'send', event);
            messages.sendMessage(message);
        }
    });
});

