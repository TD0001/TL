package game.enemy;

import game.renderer.AnimationRenderer;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyType2 extends Enemy {
    public EnemyType2() {

    }

    @Override
    public void creatRenderer() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("assets/images/enemies/level0/black");
        this.renderer = new AnimationRenderer(images);
    }


}
