/*
 * MASH View Manager
 */

module.require('smash/message').then(function(messages) {

    var contract = 'com.amazon.mash.preferences';

    module.register({
        version : 1,

        open : function(bucket) {

            return {
                bucket: bucket,

                getValue : function(name) {
                    var message = messages.obtainMessage(contract, 'getValue',
                        {bucket: this.bucket, name: name});
                    return messages.postMessage(message).then(function(message) {
                        return message.value;
                    });
                },

                setValue : function(name, value) {
                    var message = messages.obtainMessage(contract, 'setValue',
                        {bucket: this.bucket, name: name, value: value});
                    messages.sendMessage(message);
                }
            };
        }
    });
});

