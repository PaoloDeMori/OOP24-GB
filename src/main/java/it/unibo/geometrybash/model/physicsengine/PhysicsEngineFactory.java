package it.unibo.geometrybash.model.physicsengine;

/**
 * A factory interface to create PhysicsEngines.
 */
@FunctionalInterface
public interface PhysicsEngineFactory {
    /**
     * Creates a physics engine.
     * 
     * @return the physics engine.
     */
    PhysicsEngine createPhysicsEngine();
}
