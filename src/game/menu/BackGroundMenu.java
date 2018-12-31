package game.menu;

import game.Background;
import game.GameObject;
import game.settings;

import java.awt.*;

public class BackGroundMenu extends GameObject {
    public BackGroundMenu(){
        this.position.set(385,0);
        GameObject.topLayer.add(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)this.position.x,(int)this.position.y, settings.screen_width - 384, settings.screen_height);
    }
}
