package it.unibo.geometrybash.view.core;

/**
 * An immutable container providing global environmental data to the rendering system.
 *
 * <p>The {@code RenderContext} passed to all game object renderers.
 * It encapsulates the necessary information to transform world coordinates into pixels.
 *
 * @param camera the {@link Camera2D} instance responsible for coordinate transformation and scaling
 * @param viewportWidth the current width of the drawing area in pixels
 * @param viewportHeight the current height of the drawing area in pixels
 */
public record RenderContext(Camera2D camera, int viewportWidth, int viewportHeight) {

}
