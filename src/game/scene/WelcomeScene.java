package game.scene;

import game.GameObject;

public class WelcomeScene extends Scene{
    @Override
    public void init(){
        GameObject.recycleGameObjects(BackgroundWelcomeScene.class);
    }
    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
