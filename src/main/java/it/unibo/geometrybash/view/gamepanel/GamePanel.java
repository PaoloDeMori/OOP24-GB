package it.unibo.geometrybash.view.gamepanel;

import java.util.Optional;

import it.unibo.geometrybash.view.UpdatableWithDto;

public interface GamePanel {
    public Optional<UpdatableWithDto<?>> getUpdatableWithDto();
}
