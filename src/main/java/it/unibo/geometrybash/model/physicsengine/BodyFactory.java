package it.unibo.geometrybash.model.physicsengine;

import org.jbox2d.dynamics.Body;

import it.unibo.geometrybash.model.geometry.Shape;
import it.unibo.geometrybash.model.obstacle.Obstacle;
import it.unibo.geometrybash.model.player.Player;
import it.unibo.geometrybash.model.powerup.PowerUp;

/**
 * A factory that creates JBox2d instances.
 */
public interface BodyFactory {

    /**
     * Create the Obstacle representation in the physics engine.
     * 
     * @param obj the obstacle to represent in the physical world
     * @return the obstacle just created
     */
    Body createObstacle(Obstacle obj);

    /**
     * Create the powerup representation in the physics engine.
     * 
     * @param obj the powerup to represent in the physical world
     * @return the powerup just created
     */
    Body createPowerUp(PowerUp<? extends Shape> obj);

    /**
     * Create the player representation in the physics engine.
     * 
     * @param p the player to represent in the physical world
     * @return the player just created
     */
    Body createPlayer(Player<? extends Shape> p);
}
