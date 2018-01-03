/*
 * Implements the Transition class.
 */

module.require('smash/message').then(function(messages) {

    var contract = 'com.amazon.mash.view';

    function TransitionManager() {
        this.targets = [];
        this.clickTime = -1;
    }

    TransitionManager.version = 2;
    TransitionManager.PORTRAIT = "PORTRAIT";
    TransitionManager.LANDSCAPE = "LANDSCAPE";

    /**
     * Adds a target view token to be used by the transition without specifying an explicit animation.
     */
    TransitionManager.prototype.addTarget = function(target) {
        this.targets.push(target);
    }

    /**
     * Associates animations with view tokens to control how these views animate during a transition.
     * There is only a single transition configured at this time. If you want to use multiple
     * transitions, you need to use one of the transition sets.
     */
    TransitionManager.prototype.addTransition = function(target) {
        this.targets.push(target);
    }

    /**
     * Sets the click time of the click which triggered this transition.
     * Value is in millis since Jan 1, 1970
     */
    TransitionManager.prototype.setClickTime = function(click) {
        this.clickTime = click
    }

    /**
     * Sets what orientation the transition is based on.
     * TransitionManager.PORTRAIT or TransitionManager.LANDSCAPE.
     */
    TransitionManager.prototype.setOrientation = function(orientation) {
        if (TransitionManager.PORTRAIT == orientation || TransitionManager.LANDSCAPE == orientation) {
            this.orientation = orientation;
        } else {
            throw "orientation must be TransitionManager.PORTRAIT or TransitionManager.LANDSCAPE, but it's " + orientation;
        }
    }

    /**
     * Executes a transition previously configured using addTarget() and addTransition().
     */
    TransitionManager.prototype.execute = function() {
        var data = {transitions: this.targets};
        if (this.clickTime > 0) {
            data.clickTime = this.clickTime;
        }
        data.orientation = this.orientation;
        var message = messages.obtainMessage(contract, 'transition', data);
        return messages.postMessage(message);
    }

    /**
     * Retrieves the transition which navigated to the current page.  Returns a promise
     * that is resolved with the same message as the original call to execute().  If the current page
     * was not arrived at through a transition, the promise will be rejected.
     */
    TransitionManager.getEnteringTransition = function() {
        var message = messages.obtainMessage(contract, 'getEnteringTransition', {});
        return messages.postMessage(message);
     }

    module.register(TransitionManager);
});

