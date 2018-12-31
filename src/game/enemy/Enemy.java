package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.player.Player;
import game.renderer.AnimationRenderer;
import game.scene.Scene;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Enemy extends GameObject implements Physics {
    BoxCollider boxCollider;
    public Enemy() {
        this.creatRenderer();
        this.boxCollider = new BoxCollider(this, 20,20);
        GameObject.midLayer.add(this);
    }


    public abstract void creatRenderer();


    @Override
    public void run() {
        super.run();
        this.hitPlayer();
    }

    private void hitPlayer() {
        Player player = GameObject.findIntersects(Player.class, this.boxCollider);
        if (player != null){
            this.destroy();
            player.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;

    }
    @Override
    public void destroy(){
        super.destroy();
        EnemyExplosion explosion = GameObject.recycleGameObjects(EnemyExplosion.class);
        explosion.position.set(this.position);
        Scene.score++;
    }
}
