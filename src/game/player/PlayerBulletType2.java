package game.player;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import game.settings;
import tklibs.SpriteUtils;
import tklibs.vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletType2 extends PlayerBullet {
    vector2D explosionPoint;
    Renderer bulletRenderer;
    Renderer explosionRenderer;

    public PlayerBulletType2(){

        this.explosionPoint = new vector2D(settings.screen_width/4, settings.screen_height/3);
    }

    @Override
    protected void creatBoxCollider() {
        this.boxCollider = new BoxCollider(this, 20,20);
    }

    public  void setVelocityToExplosionPoint(vector2D startPoint){
        vector2D velocity = explosionPoint.clone().subtractThis(startPoint).setLength(7);
        this.velocity.set(velocity);
    }
    @Override
    public void creatRenderer() {

        this.bulletRenderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/enemies/bullets"));
        this.renderer = this.bulletRenderer;
    }

    @Override
    public void hitEnemy() {

    }

    @Override
    public void run(){
        super.run();
        this.checkExplosion();
    }

    private void checkExplosion() {
        if(this.explosionPoint.clone().subtractThis(this.position).getLength() <7
        && this.renderer.equals(this.bulletRenderer)){
            this.creatExplosionRenderer();
            System.out.println("Explosion");
            this.velocity.set(0,0);
        }
    }

    private void creatExplosionRenderer() {


        this.explosionRenderer= new AnimationRenderer(SpriteUtils.loadImages("assets/images/enemies/explosion-big"), true);
        this.renderer =this.explosionRenderer;
    }

    @Override
    public void reset(){
        super.reset();
        this.renderer = this.bulletRenderer;

}}
