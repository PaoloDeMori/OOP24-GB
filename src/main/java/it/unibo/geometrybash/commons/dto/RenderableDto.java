package it.unibo.geometrybash.commons.dto;

/**
 * Base DTO for all renderable objects.
 *
 * @param x the X position in world coordinates
 * @param y the Y position in world coordinates
 * @param width the width
 * @param height the height
 */
public record RenderableDto(float x, float y, float width, float height) {

}
