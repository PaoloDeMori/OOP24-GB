package it.unibo.geometrybash.model.physicsengine;

import it.unibo.geometrybash.model.AbstractGameModel;

/**
 * An Abstract implementation of the {@link GameModelWithPhysicsEngine}
 * interface that implements the getter and setter of the physics engine.
 */
public abstract class AbstractGameModelWithPhysicsEngine extends AbstractGameModel
        implements GameModelWithPhysicsEngine {
    private PhysicsEngine physicsEngine;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPhysicsEngine(final PhysicsEngineFactory pEF) {
        this.physicsEngine = pEF.createPhysicsEngine();
    }

    /**
     * Let the subclasses access physicsEngine.
     * 
     * @return physicsEngine
     */
    protected PhysicsEngine getPhysicsEngine() {
        return this.physicsEngine;
    }

}
