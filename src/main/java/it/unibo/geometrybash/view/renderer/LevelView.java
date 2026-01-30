package it.unibo.geometrybash.view.renderer;

import java.awt.Graphics2D;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unibo.geometrybash.commons.dtos.GameStateDto;
import it.unibo.geometrybash.view.core.RenderContext;
import it.unibo.geometrybash.view.core.SpriteRegistry;

public class LevelView implements Drawable<GameStateDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LevelView.class);


    private final ObstacleView obstacleView;
    private final PowerUpView powerUpView;
    private final PlayerView playerView;

    private final SpriteRegistry spriteRegistry;

    public LevelView(final SpriteRegistry spriteRegistry) {
        this.spriteRegistry = spriteRegistry;
        this.obstacleView = new ObstacleView(this.spriteRegistry);
        this.powerUpView = new PowerUpView(this.spriteRegistry);
        this.playerView = new PlayerView(this.spriteRegistry);
    }

    @Override
    public void draw(final Graphics2D g2d, final RenderContext renderContext, final GameStateDto data) {
        if (data != null) {
            this.obstacleView.draw(g2d, renderContext, data.obstacles());
            this.powerUpView.draw(g2d, renderContext, data.powerUps());
            this.playerView.draw(g2d, renderContext, data.player());
        }
        else{
            LOGGER.warn("Level drawn without any information about the world");
        }
    }

}
