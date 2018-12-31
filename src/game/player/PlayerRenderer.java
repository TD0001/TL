package game.player;

import game.GameObject;
import game.renderer.AnimationRenderer;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;

public class PlayerRenderer extends Renderer {
    AnimationRenderer leftAnimation;
    AnimationRenderer rightAnimation;
    AnimationRenderer straightAnimation;

    public PlayerRenderer(){
        this.leftAnimation = new AnimationRenderer(SpriteUtils.loadImages("D:\\session_1\\ci-begin-master\\assets\\images\\players\\left"));
        this.rightAnimation = new AnimationRenderer(SpriteUtils.loadImages("D:\\session_1\\ci-begin-master\\assets\\images\\players\\right"));
        this.straightAnimation = new AnimationRenderer(SpriteUtils.loadImages("D:\\session_1\\ci-begin-master\\assets\\images\\players\\straight"));
    }

    @Override
    public void render(Graphics g, GameObject master){
        float vX= master.velocity.x;
        if (vX<0){
            this.leftAnimation.render(g,master);
        } else if (vX==0){
            this.straightAnimation.render(g,master);
        } else{
            this.rightAnimation.render(g, master);
        }
    }
}
