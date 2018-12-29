package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        super();
        this.position.set(0, settings.screen_height- image.getHeight());
        BufferedImage image = SpriteUtils.loadImage("D:\\session_1\\ci-begin-master\\assets\\images\\background\\0.png");
        this.renderer =new SingleImageRenderer(image);
        this.velocity.set(0,11);
        this.anchor.set(0,0);
        GameObject.botLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y>=0){
            this.velocity.set(0,0);
            this.position.set(0,0);
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        System.out.println(">>>");
    }
}