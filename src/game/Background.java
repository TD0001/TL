package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer =new SingleImageRenderer(image);
        this.position.set(0, settings.screen_height- image.getHeight());
        this.velocity.set(0,11);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y>=0){
            this.velocity.set(settings.PLAYER_START_POSITION_X,settings.PLAYER_START_POSITION_Y);
            this.position.set(settings.PLAYER_START_POSITION_X,settings.PLAYER_START_POSITION_Y);
        }
    }
}