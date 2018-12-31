package game.scene;

import game.Background;
import game.GameObject;
import game.GameWindow;
import game.renderer.SingleImageRenderer;
import game.settings;
import tklibs.SpriteUtils;

public class BackgroundWelcomeScene extends GameObject {
    public BackgroundWelcomeScene(){
        this.position.set(settings.screen_width/2, settings.screen_height/2);
        this.renderer = new SingleImageRenderer(
                SpriteUtils.loadImage("D:\\session_1\\ci-begin-master\\assets\\images\\background\\images.png")
        );
        GameObject.botLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isAnyKeyPress){
            Scene.signNewScene(new SceneStage1());
        }
    }
}
