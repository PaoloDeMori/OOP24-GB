package it.unibo.geometrybash.model.collision;

import it.unibo.geometrybash.model.core.GameObject;

public final class CollisionEvent {

    private final GameObject objectA;
    private final GameObject objectB;
    private final CollisionPhase phase;

    public CollisionEvent(GameObject a, GameObject b, CollisionPhase phase) {
        this.objectA = a;
        this.objectB = b;
        this.phase = phase;
    }

    public GameObject getObjectA() {
        return objectA;
    }

    public GameObject getObjectB() {
        return objectB;
    }

    public CollisionPhase getPhase() {
        return phase;
    }

    public boolean isBegin() {
        return phase.equals(CollisionPhase.BEGIN);
    }

    public boolean isEnd() {
        return phase.equals(CollisionPhase.END);
    }
}

