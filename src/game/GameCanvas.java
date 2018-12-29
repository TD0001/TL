package game;

import game.enemy.Enemy;
import game.player.Player;
import game.scene.Scene;
import game.scene.WelcomeScene;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {


    public GameCanvas() {
//        //this.background = new Background();
//        GameObject.recycleGameObjects(Background.class);
//        //this.player = new Player();
//        GameObject.recycleGameObjects(Player.class);
//        Enemy enemy = GameObject.recycleGameObjects(Enemy.class);
//        enemy.position.set(200,300);
        Scene.signNewScene(new WelcomeScene());
    }

    public void run() {
        long delay = 1000 / 60;
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                GameObject.runAll();
                this.repaint(); // ~paint
                lastTime = currentTime;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, settings.screen_width, settings.screen_height);
//        this.background.render(g);
//        this.player.render(g);
//        for (int i=0; i<bullets.size();i++){
//            PlayerBulletType1 bullet =bullets.get(i);
//                if (bullet.active) {
//                    bullets.get(i).render(g);
//                }
//            }
//
//        }
        GameObject.renderAll(g);
    }
}

