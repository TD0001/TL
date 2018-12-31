package game.scene;

import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import game.renderer.SingleImageRenderer;
import game.settings;
import tklibs.SpriteUtils;

import java.awt.font.GlyphMetrics;

public class BackgroundGameOverScene extends GameObject {
    FrameCounter idleCounter;
    public BackgroundGameOverScene(){
        this.renderer = new SingleImageRenderer(
                SpriteUtils.loadImage("assets/images/background/70012244-wedding-couple-game-over-for-the-man.jpg")

        );
        this.position.set(settings.screen_width/2, settings.screen_height/2);
        this.idleCounter = new FrameCounter(60);
        GameObject.midLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (this.idleCounter.count() && GameWindow.isAnyKeyPress){
            System.exit(0);
        }
    }
}
