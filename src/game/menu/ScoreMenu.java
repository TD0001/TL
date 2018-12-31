package game.menu;

import game.GameObject;
import game.renderer.TextRenderer;
import game.scene.Scene;
import game.settings;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreMenu extends GameObject {
    TextRenderer scoreRenderer;
    BufferedImage enemyImage;
    public ScoreMenu(){
        this.scoreRenderer = new TextRenderer(Scene.score + "", Color.WHITE,
                settings.Font_Lg);
        this.renderer = scoreRenderer;
        this.position.set(600, 300);
        GameObject.topLayer.add(this);
        this.enemyImage = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
    }
    @Override
    public void run(){
      super.run();
      this.scoreRenderer.text = Scene.score + "";

    }

    @Override
    public void render(Graphics g) {
        super.render(g);// this.render.render(); ~ draw string
        g.drawImage(this.enemyImage, (int)this.position.x -40,(int)this.position.y -25, null);
    }
}
