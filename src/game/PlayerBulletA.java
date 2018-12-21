package game;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class PlayerBulletA extends GameObject{
    public PlayerBulletA(){
        this.creatRenderer();
        this.velocity.set(2,-7);
    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new AnimationRenderer(images);
    }
}
