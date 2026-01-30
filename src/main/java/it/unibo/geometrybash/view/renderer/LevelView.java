package it.unibo.geometrybash.view.renderer;

import java.awt.Graphics2D;
import java.util.List;

import it.unibo.geometrybash.commons.dtos.GameStateDto;
import it.unibo.geometrybash.commons.dtos.ObstacleDto;
import it.unibo.geometrybash.commons.dtos.PlayerDto;
import it.unibo.geometrybash.commons.dtos.PowerUpDto;
import it.unibo.geometrybash.view.core.RenderContext;
import it.unibo.geometrybash.view.core.SpriteRegistry;

public class LevelView implements Drawable<GameStateDto> {

    private List<ObstacleDto> obstaclesDto;
    private List<PowerUpDto> powerUpDto;
    private PlayerDto playerDto;

    private final ObstacleView obstacleView;
    private final PowerUpView powerUpView;
    private final PlayerView playerView;

    private SpriteRegistry spriteRegistry;

    public LevelView(SpriteRegistry spriteRegistry) {
        this.spriteRegistry = spriteRegistry;
        this.obstacleView = new ObstacleView(this.spriteRegistry);
        this.powerUpView = new PowerUpView(this.spriteRegistry);
        this.playerView = new PlayerView(this.spriteRegistry);
    }

    @Override
    public void draw(Graphics2D g2d, RenderContext renderContext, GameStateDto data) {
        if (this.obstaclesDto != null && this.powerUpDto != null && this.playerDto != null) {
            this.obstacleView.draw(g2d, renderContext, data.obstacles());
            this.powerUpView.draw(g2d, renderContext, data.powerUps());
            this.playerView.draw(g2d, renderContext, data.player());
        }
    }

}
