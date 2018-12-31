package game.scene;

import game.GameObject;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        GameObject.recycleGameObjects(BackgroundGameOverScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
