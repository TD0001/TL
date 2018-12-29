package game.player;

import game.*;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.AnimationRenderer;
import game.scene.GameOverScene;
import game.scene.Scene;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    public Player() {
        super();
        this.creatRenderer();
        this.position.set(settings.PLAYER_START_POSITION_X, settings.PLAYER_START_POSITION_Y);
        this.fireCounter = new FrameCounter(20);
        this.boxCollider = new BoxCollider(this, 20, 30);
        GameObject.midLayer.add(this);
    }

    private void creatRenderer() {
//        ArrayList<BufferedImage> images = new ArrayList<>();
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
//        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
//        this.renderer = new AnimationRenderer(images);
        this.renderer = new PlayerRenderer();
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPlayerPosition();
    }

    //todo continue editting

    private void fire() {

        if (this.fireCounter.count()) {
            float angle = (float) (-Math.PI / 8);
            float offset = (float) (Math.PI / 8);

            for (int i = 0; i < 3; i++) {
                if (GameWindow.isFirePress) {
                    PlayerBulletType1 bullet = GameObject.recycleGameObjects(PlayerBulletType1.class);
                    bullet.position.set(this.position);
                    bullet.velocity.setLength(7).setAngle(angle - i * offset);
                }
            }
//            if (GameWindow.isFirePress) {
//                PlayerBulletType2 bullet = GameObject.recycleGameObjects(PlayerBulletType2.class);
//
//                bullet.position.set(this.position);
//                bullet.setVelocityToExplosionPoint(this.position);
//            }
//            if (GameWindow.isFirePress) {
//                PlayerBulletType1 bullet2 = new PlayerBulletType1();
//                bullet2.position.set(this.position);
//                bullet2.velocity.set(-1,-1).setLength(1);
//                GameCanvas.bullets.add(bullet2);
//            }
//
//
//            if (GameWindow.isFirePress) {
//                PlayerBulletType1 bullet3 = new PlayerBulletType1();
//                bullet3.position.set(this.position);
//                GameCanvas.bullets.add(bullet3);
//            }
            this.fireCounter.reset();
        }
    }


    private void limitPlayerPosition() {
        if (this.position.x < 16) {
            this.position.set(16, this.position.y);
        }
        if (this.position.x > 384 - 16) {
            this.position.set(384 - 16, this.position.y);
        }
        if (this.position.y < 24) {
            this.position.set(this.position.x, 24);
        }
        if (this.position.y > settings.screen_height - 24) {
            this.position.set(this.position.x, settings.screen_height - 24);
        }
    }

    private void move() {

        this.velocity.set(0, 0);
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
        this.velocity.setLength(3);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void destroy() {
        super.destroy();
        Scene.signNewScene(new GameOverScene());
    }
}
