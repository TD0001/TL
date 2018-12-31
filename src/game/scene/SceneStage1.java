package game.scene;

import game.Background;
import game.GameObject;
import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.menu.BackGroundMenu;
import game.menu.ScoreMenu;
import game.player.Player;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SceneStage1 extends Scene {
    Clip music;
    @Override
    public void init(){
                //this.background = new Background();
        GameObject.recycleGameObjects(Background.class);
        //this.player = new Player();
        GameObject.recycleGameObjects(Player.class);
        GameObject.recycleGameObjects(EnemySummoner.class);
        GameObject.recycleGameObjects(BackGroundMenu.class);
        GameObject.recycleGameObjects(ScoreMenu.class);
        this.music = AudioUtils.loadSound("assets/music/national-anthem-of-ussr.wav");
        FloatControl musicControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        musicControl.setValue(-20);


        AudioUtils.replay(this.music);
    }

    @Override
    public void clear(){
        GameObject.clearAll();
        this.music.stop();
    }
}
