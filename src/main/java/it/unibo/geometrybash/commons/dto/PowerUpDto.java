package it.unibo.geometrybash.commons.dto;

/**
 * DTO for power-up rendering.
 *
 * @param x the X position
 * @param y the Y position
 * @param width the width
 * @param height the height
 * @param type the power-up type identifier
 */
public record PowerUpDto(float x, float y, float width, float height, String type) {

}
