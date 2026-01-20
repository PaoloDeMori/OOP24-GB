package it.unibo.geometrybash.model.powerup;

import it.unibo.geometrybash.model.core.GameObject;
import it.unibo.geometrybash.model.geometry.Shape;

/**
 * Represents a collectible power-up in the game.
 *
 * <p>Power-ups can be permanent (coins) or temporary
 */
public interface PowerUp<S extends Shape> extends GameObject<S> {

    /**
     * Returns the type of this power-up.
     *
     * @return the power-uo type
     */
    PowerUpType getPowerUpType();

    /**
     * Checks if this power-up has a temporary effect.
     *
     * @return true if temporary, false otherwise
     */
    boolean isTemporary();

    /**
     * Returns the duration of the effect in seconds.
     *
     * @return duration in seconds, or 0 if it is permanent power-up
     */
    float getDuration();

}
