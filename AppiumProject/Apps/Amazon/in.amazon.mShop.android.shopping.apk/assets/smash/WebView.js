/*
 * Implements WebView.
 */

module.requireAll('smash/message', 'smash/View').spread(function(messages, View) {

    var contract = 'com.amazon.mash.webview';

    function WebView() {
    }

    WebView.version = 1;

    WebView.getCurrentView = function() {
        var message = messages.obtainMessage(contract, 'getCurrentView', {});
        return messages.postMessage(message).then(function(message) {
            return View.fromId(message.id);
        });
    }

    module.register(WebView);
});

