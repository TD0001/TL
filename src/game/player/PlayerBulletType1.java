package game.player;

import game.GameObject;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.AnimationRenderer;
import tklibs.AudioUtils;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType1 extends PlayerBullet {
    public PlayerBulletType1(){

        this.velocity.set(0,-7);

    }

    @Override
    protected void creatBoxCollider() {

    }


    @Override
    public void creatRenderer() {

        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/player-bullets/a"));
    }

    @Override
    public void hitEnemy() {
        AudioUtils.replay(this.intersectSound);
        this.destroy();
    }

    @Override
    public void run(){
        super.run();
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.boxCollider);
        if (enemy != null){
            this.hitEnemy();
            enemy.destroy();
        }
        this.checkOutOfBound();

    }


    private void checkOutOfBound() {
        if(this.position.y <0){
            this.destroy();
        }
    }
    }

