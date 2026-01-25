package it.unibo.geometrybash.model.player;

import it.unibo.geometrybash.model.geometry.HitBox;

/**
 * Interface representing a player in an implementation of the gamemodel using a physics engine.
 */
public interface PlayerWithPhysics extends Player<HitBox>, Bindable { }
