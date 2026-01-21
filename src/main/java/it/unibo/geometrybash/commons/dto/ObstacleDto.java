package it.unibo.geometrybash.commons.dto;

/**
 * DTO for obstacle rendering.
 *
 * @param x the X position
 * @param y the Y position
 * @param width the width
 * @param height the height
 * @param type the obstacle type identifier
 */
public record ObstacleDto(float x, float y, float width, float height, String type) {

}
