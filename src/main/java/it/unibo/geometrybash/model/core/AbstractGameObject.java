package it.unibo.geometrybash.model.core;

import it.unibo.geometrybash.model.geometry.HitBox;
import it.unibo.geometrybash.model.geometry.Vector2;

public abstract class AbstractGameObject implements GameObject{

    protected Vector2 position;
    protected HitBox hitBox;
    protected boolean active = true;

    protected AbstractGameObject(Vector2 position, HitBox hitBox) {
        this.position = position;
        this.hitBox = hitBox;
        this.active = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2 getPosition() {
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends GameObject> getType() {
        return this.getClass();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Must be implemented by concrete game objects.
     * </p>
     */
    @Override
    public abstract void update(float dt);

}
