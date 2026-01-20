package it.unibo.geometrybash.model.powerup;

import it.unibo.geometrybash.model.geometry.CircleHitBox;
import it.unibo.geometrybash.model.geometry.Vector2;

/**
 * Represent a {@link PowerUp} that grants a shield to the player.
 *
 * <p>
 * The shield protects the player from one deadly collision.
 */
public final class ShieldPowerUp extends AbstractPowerUp<CircleHitBox> {

    /**
     * Size of the square hitbox of the power-up.
     */
    public static final int RADIUS = 12;

    /**
     * Creates a new {@code ShieldPowerUp} at the given position.
     *
     * @param position the initial position of the power-up in the game world
     */
    public ShieldPowerUp(final Vector2 position) {
        super(position, new CircleHitBox(RADIUS), PowerUpType.SHIELD, 0);
    }

    /**
     * Creates a defense copy of this power-up.
     *
     * <p>
     * The copy preserves the position and the active state.
     *
     * @return a new {@code SpeedBoostPowerUp} with the same state as this instance
     */
    @Override
    public ShieldPowerUp copy() {
        final ShieldPowerUp copyShieldPowerUp = new ShieldPowerUp(this.position);
        copyShieldPowerUp.setActive(this.active);
        return copyShieldPowerUp;
    }

    @Override
    public Class<ShieldPowerUp> getType() {
       return ShieldPowerUp.class;
    }

}
