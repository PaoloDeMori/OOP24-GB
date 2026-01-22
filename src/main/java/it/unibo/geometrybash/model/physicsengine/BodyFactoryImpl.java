package it.unibo.geometrybash.model.physicsengine;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import it.unibo.geometrybash.model.core.GameObject;
import it.unibo.geometrybash.model.geometry.CircleHitBox;
import it.unibo.geometrybash.model.geometry.HitBox;
import it.unibo.geometrybash.model.geometry.Shape;
import it.unibo.geometrybash.model.obstacle.Obstacle;
import it.unibo.geometrybash.model.player.Player;

public class BodyFactoryImpl implements BodyFactory{
    private World world;

    protected BodyFactoryImpl(float gravityX,float gravityY){
        newWorld(gravityX, gravityY);
    }

    @Override
    public Body createObstacle(Obstacle obj) {
        Shape hB = gO.getHitBox();
        if(hB instanceof CircleHitBox){
            CircleHitBox cHB= (CircleHitBox)hB;
            CircleShape circleShape= new CircleShape();
            circleShape.m_radius=cHB.getRadius();
            if(gO instanceof )
            
        }
        else if(hB instanceof HitBox){

        }
    }
    @Override
    public Body createPlayer(Player p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPlayer'");
    }
    @Override
    public World newWorld(float gravityX,float gravityY) {
        this.world=new World(new Vec2(gravityX, gravityY));
        return this.world;
    }
    @Override
    public World getWorld() {
        return this.world;
    }

    
}
