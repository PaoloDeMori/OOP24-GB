package it.unibo.geometrybash.model;

import it.unibo.geometrybash.commons.pattern.observerpattern.modelobserver.ModelObservable;
import it.unibo.geometrybash.model.exceptions.ErrorUpdatingModel;

/**
 * The Business logic of the Game.
 * This interface offers a contract to access and modify the gamestatus and the main entities of the game.
 * 
 */
public interface GameModel extends ModelObservable {

    /**
     * Returns the player of the game.
     * 
     * @return The player of the game.
     */
    Player getPlayer();

    /**
     * Returns the level of the game.
     * 
     * @return the level of the game.
     */
    Level getLevel();

    /**
     * Update the model
     */
    void update() throws ErrorUpdatingModel;
}
