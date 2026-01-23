package it.unibo.geometrybash.commons.dto;

/**
 * DTO for player rendering.
 *
 * @param x the X position
 * @param y the Y position
 * @param width the width
 * @param height the height
 * @param rotation the rotation gives to the player's movement
 * @param state the player's state
 * @param hasShield whether player has active shield
 */
public record PlayerDto(float x, float y, float width, float height, boolean isActive, float rotation, boolean hasShield, SkinDTO skin) {

}
