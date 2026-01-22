package it.unibo.geometrybash.model.physicsengine;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import it.unibo.geometrybash.model.obstacle.Obstacle;
import it.unibo.geometrybash.model.player.Player;

public interface BodyFactory {

    Body createObstacle(Obstacle obj);

    Body createPlayer(Player p);

    World newWorld(float gravityX,float gravityY);

    World getWorld();
}
