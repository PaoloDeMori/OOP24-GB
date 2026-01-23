package it.unibo.geometrybash.commons.dto;

import java.util.List;

import it.unibo.geometrybash.model.Status;

/**
 * DTO containing all data needed to render a frame.
 *
 * @param player the player data
 * @param obstacles the list of obstacles
 * @param powerUps the list of power-ups
 * @param cameraOffsetX the camera X offset
 * @param score the current score/coins
 * @param status the current game's status
 */
public record GameStateDto(
    PlayerDto palyer,
    List<ObstacleDto> obstacles,
    List<PowerUpDto> powerUps,
    float cameraOffsetX,
    int score,
    Status gameStatus
) { }
