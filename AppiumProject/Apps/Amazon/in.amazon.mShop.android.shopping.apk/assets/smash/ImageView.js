/*
 * Implements ImageView.
 */

module.requireAll('smash/message', 'smash/View').spread(function(messages, View) {

    var contract = 'com.amazon.mash.imageview';

    function ImageView() {
    }

    ImageView.version = 1;

    /**
     * Return the DATA URL of an image.
     */
    ImageView.asDataUrl = function(image) {
        var canvas = document.createElement('canvas');
        var context = canvas.getContext('2d');
        canvas.width = image.naturalWidth;
        canvas.height = image.naturalHeight;
        context.drawImage(image, 0, 0);
        return canvas.toDataURL("image/png");
    }

    ImageView.create = function(spec) {
        var message = messages.obtainMessage(contract, 'create', spec);
        return messages.postMessage(message).then(function(message) {
            return View.fromId(message.id);
        });
    }

    module.register(ImageView);
});

