package game.enemy;

import game.GameObject;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion(){
        this.renderer = new AnimationRenderer(
                SpriteUtils.loadImages("assets/images/enemies/explosion"),
                true
        );
    }

    @Override
    public void reset() {
        super.reset();
        this.renderer.reset();
    }
}
