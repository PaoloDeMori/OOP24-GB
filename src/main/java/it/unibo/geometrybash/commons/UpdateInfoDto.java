package it.unibo.geometrybash.commons;

import java.io.Serializable;

import it.unibo.geometrybash.commons.dtos.GameStateDto;

/**
 * The information used to update the view.
 *
 * <p>This Data Transfer Object should be used by the {@link it.unibo.geometrybash.controller.Controller} to send the view
 * the information to update after a cycle of gameloop.
 * Implements {@link Serializable} to ensure a correct communciation
 *
 *
 * @see it.unibo.geometrybash.controller.Controller
 */
public class UpdateInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private final GameStateDto gameState;

    /**
     * Void constructor place holder.
     */
    public UpdateInfoDto(final GameStateDto gameState) {
        this.gameState = gameState;
    }

    public GameStateDto getStateDto() {
        return this.gameState;
    }
}
