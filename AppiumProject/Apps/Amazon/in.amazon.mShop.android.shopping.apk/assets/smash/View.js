/*
 * Implements View.
 */

module.require('smash/message').then(function(messages) {

    var contract = 'com.amazon.mash.view';

    function View(id) {
        if (id == null) {
            throw Error('Cannot create view with null id');
        }
        this.id = id;
    }

    View.version = 1;

    View.fromId = function(id) {
        return new View(id);
    }

    View.findByTag = function(tag) {
        var message = messages.obtainMessage(contract, 'findViewByTag', {tag:tag});
        return messages.postMessage(message).then(function(message) {
            return View.fromId(message.id);
        });
    }

    View.setTag = function(tag) {
        var message = messages.obtainMessage(contract, 'setTag', {id: this.id, tag:tag});
        return messages.sendMessage(message);
    }

    View.prototype.getInfo = function() {
        var message = messages.obtainMessage(contract, 'getViewInfo', {id: this.id});
        return messages.postMessage(message);
    }

    module.register(View);
});

