package game;

import game.GameObject;
import game.GameWindow;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;
import tklibs.vector2D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {


    public Player() {
        super();
        this.creatRenderer();
        this.position.set(200, 400);

    }

    private void creatRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPlayerPosition();
        }
    int count =0;
    private void fire() {
        this.count++;
        if (this.count >20) {
            if (GameWindow.isFirePress) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(this.position);
                GameCanvas.bullets.add(bullet);

            }
            if (GameWindow.isFirePress) {
                PlayerBulletA bulletA = new PlayerBulletA();
                bulletA.position.set(this.position);
                GameCanvas.bullet1s.add(bulletA);
            }
            this.count =0;
        }
    }


    private void limitPlayerPosition() {
        if (this.position.x <0){
            this.position.set(0, this.position.y);
        }
        if (this.position.x > 384-32){
            this.position.set(384 - 32,this.position.y);
        }
        if (this.position.y <0){
            this.position.set(this.position.x,0);
        }
        if (this.position.y > settings.screen_height-48){
            this.position.set(this.position.x, settings.screen_height -40);
        }
    }

    private void move() {

        this.velocity.set(0,0);
        if (GameWindow.isUpPress) {
//            this.position.y--;
            this.velocity.addThis(0, -1);
        }
        if (GameWindow.isDownPress) {
            this.velocity.addThis(0, +1);
        }
        if (GameWindow.isLeftPress) {
            this.velocity.addThis(-1, 0);
        }
        if (GameWindow.isRightPress) {
            this.velocity.addThis(+1, 0);
        }
        this.velocity.setLength(1);
    }

}
