package it.unibo.geometrybash.controller;

import it.unibo.geometrybash.commons.pattern.observerpattern.modelobserver.ModelObserver;
import it.unibo.geometrybash.model.Status;
import it.unibo.geometrybash.view.View;

/**
 * The controller of the application.
 */
public interface Controller extends ModelObserver {

    /**
     * Returns the status of the {@link it.unibo.geometrybash.model.GameModel} used
     * by this class.
     * 
     * @return the status of the of the gamemodel.
     * @see View
     */
    Status getModelStatus();

    /**
     * Starts the game.
     */
    void start();
}
