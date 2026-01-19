package it.unibo.geometrybash.model.physics;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import it.unibo.geometrybash.model.geometry.Vector2;

public interface PlayerPhysics {

    /**
     * Applies a vertical impulse to make the player jump.
     * <p>
     * If the player has one or more ground contacts, the vertical velocity is reset to zero,
     * and a vertical impulse of magnitude {@code JUMP_IMPULSE} is applied at the body's
     * center of mass.
     * </p>
     */
    void applyJump();

    /**
     * Multiplies the player's current linear velocity by the specified factor.
     * <p>
     * The horizontal velocity component is multiplied by {@code multiplier}, while the vertical
     * component remains unchanged.
     * </p>
     *
     * @param multiplier the factor to scale the horizontal velocity
     */
    void setVelocity(float multiplier);

    /**
     * Returns the current linear velocity of the player.
     * <p>
     * Converts the JBox2D {@link Vec2} velocity into the domain-specific {@link Vector2} type.
     * </p>
     *
     * @return a {@link Vector2} representing the player's current velocity
     */
    Vector2 getVelocity();

    /**
     * Returns whether the player is in contact with the ground.
     * <p>
     * Returns true if {@code groundContacts} is greater than zero.
     * </p>
     *
     * @return {@code true} if the player has ground contacts, {@code false} otherwise
     */
    boolean isGrounded();

    /**
     * Returns the JBox2D Body representing the player.
     *
     * @return the player's physical body
     */
    Body getBody();

    /**
     * Resets the player's position and velocity.
     * <p>
     * Sets the body's position to {@code pos}, rotation to zero, linear velocity to zero,
     * and angular velocity to zero.
     * </p>
     *
     * @param pos the new position of the player in world coordinates
     */
    void resetBodyTo(Vector2 pos);

    /**
     * Sets the user data for the player's body.
     * <p>
     * Associates the given object with the JBox2D body for identification or collision handling.
     * </p>
     *
     * @param userData the object to associate with the body
     */
    void setUserData(Object userData);

    /**
     * Increments the ground contact counter by one.
     * <p>
     * This updates the internal count of how many fixtures are currently colliding
     * with the player's body in a grounded state.
     * </p>
     */
    void incrementGroundContacts();

    /**
     * Decrements the ground contact counter by one.
     * <p>
     * Ensures the counter never becomes negative.
     * </p>
     */
    void decrementGroundContacts();
}
