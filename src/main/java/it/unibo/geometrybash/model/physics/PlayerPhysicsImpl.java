package it.unibo.geometrybash.model.physics;

import it.unibo.geometrybash.model.geometry.Vector2;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class PlayerPhysicsImpl implements PlayerPhysics{

    private static final float JUMP_IMPULSE = 6.5f;
    private final Body body;
    private int groundContacts;

    /**
     * Constructs a new player physics object bound to a JBox2D Body.
     *
     * @param body the JBox2D Body representing the player's physical body
     */
    public PlayerPhysicsImpl(final Body body) {
        this.body = body;
        this.groundContacts = 0;
    }

    @Override
    public void applyJump() {
        if (!isGrounded()) {
            return;
        }

        Vec2 vel = body.getLinearVelocity();
        body.setLinearVelocity(new Vec2(vel.x, 0f));

        body.applyLinearImpulse(
            new Vec2(0f, JUMP_IMPULSE),
            body.getWorldCenter()
        );
    }

    @Override
    public void setVelocity(float multiplier) {
        body.setLinearVelocity(new Vec2(body.getLinearVelocity().x * multiplier, body.getLinearVelocity().y));
    }

    @Override
    public Vector2 getVelocity() {
        return new Vector2(body.getLinearVelocity().x, body.getLinearVelocity().y);
    }

    @Override
    public boolean isGrounded() {
        return groundContacts > 0;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public void resetBodyTo(Vector2 pos) {
        body.setTransform(new Vec2(pos.x(), pos.y()), 0f);
        body.setLinearVelocity(new Vec2(0f, 0f));
        body.setAngularVelocity(0f);
    }

    @Override
    public void setUserData(Object userData) {
        body.setUserData(userData);
    }

    @Override
    public void incrementGroundContacts() {
        groundContacts++;
    }

    @Override
    public void decrementGroundContacts() {
        groundContacts = Math.max(0, groundContacts - 1);
    }

}
