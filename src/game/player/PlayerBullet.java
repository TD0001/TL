package game.player;

import game.GameObject;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.physics.Physics;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public abstract class PlayerBullet extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public Clip intersectSound;
    public PlayerBullet(){
        this.velocity.set(0,-7);
        this.boxCollider = new BoxCollider(this, 20, 20);
        this.creatRenderer();
        this.creatBoxCollider();
        GameObject.midLayer.add(this);
        this.intersectSound = AudioUtils.loadSound("assets/music/sfx/enemy-explosion.wav");
    }

    protected abstract void creatBoxCollider();

    public abstract void creatRenderer();
    @Override
    public BoxCollider getBoxCollider(){
        return this.boxCollider;
    }
    public abstract void hitEnemy();
    public void run(){
        super.run();
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.boxCollider);
        if (enemy != null){
            this.hitEnemy();
            enemy.destroy();
        }
    }

}
