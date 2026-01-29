package it.unibo.geometrybash.model.physicsengine.impl.jbox2d;

import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.collision.Manifold;
import org.jbox2d.callbacks.ContactImpulse;

import it.unibo.geometrybash.model.core.Collidable;
import it.unibo.geometrybash.model.core.GameObject;
import it.unibo.geometrybash.model.obstacle.Block;
import it.unibo.geometrybash.model.player.Player;

/**
 * Detects collisions between game objects using the JBox2D physics engine.
 *
 * <p>
 * Implements {@link ContactListener} to receive notifications when two fixtures
 * begin or end contact.
 * </p>
 */
public class CollisionHandler implements ContactListener {

    enum Phase {
        END,
        BEGIN
    }

    /**
     * Creates a new CollisionHandler.
     */
    public CollisionHandler() {
        // Default constructor.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beginContact(final Contact contact) {
        processContact(contact, Phase.BEGIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endContact(final Contact contact) {
        processContact(contact, Phase.END);
    }

    private void processContact(final Contact contact, final Phase phase) {
        final GameObject<?> a = getGameObject(contact.getFixtureA());
        final GameObject<?> b = getGameObject(contact.getFixtureB());

        if (a == null || b == null) {
            return;
        }

        if (phase == Phase.BEGIN) {
            handleBeginContact(a, b);
            handleBeginContact(b, a);
        } else {
            handleEndContact(a, b);
            handleEndContact(b, a);
        }
    }

    private GameObject<?> getGameObject(final Fixture fixture) {
        final Object userData = fixture.getBody().getUserData();
        return userData instanceof GameObject gameObject ? gameObject : null;
    }

    private void handleBeginContact(final GameObject<?> source, final GameObject<?> other) {
        if (!(source instanceof Collidable collidable) || !(other instanceof Player player)) {
            return;
        }

        if (source instanceof Block) {
            player.notifyGroundContactBegin();
        }

        collidable.onCollision(player);
        source.activateContact();
    }

    private void handleEndContact(final GameObject<?> source, final GameObject<?> other) {
        if (!(other instanceof Player player)) {
            return;
        }

        if (source instanceof Block) {
            player.notifyGroundContactEnd();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preSolve(final Contact contact, final Manifold oldManifold) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postSolve(final Contact contact, final ContactImpulse impulse) {
    }
}
