package it.unibo.geometrybash.model.player;

import it.unibo.geometrybash.model.geometry.Vector2;

public interface Player {
    void respawn(Vector2 position);

    void jump();

    PlayerState getState();

    float getForwardSpeed();

    void setForwardSpeed(float speed);

    Skin getSkin();

    void setSkin(Skin skin);
}
