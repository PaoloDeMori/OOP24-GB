package it.unibo.geometrybash.controller;

import it.unibo.geometrybash.model.GameModel;
import it.unibo.geometrybash.view.View;

public class StaticDeltaTimeControllerImpl extends AbstractControllerImpl {
    private final static float DELTA_TIME = 1 / 60;

    public StaticDeltaTimeControllerImpl(GameModel gameModel, View view, InputHandler inputHandler) {
        super(gameModel, view, inputHandler);
    }

    @Override
    protected float evaluateDeltaTime() {
        return DELTA_TIME;
    }

}
