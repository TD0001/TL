package game;

import game.Background;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    static ArrayList<PlayerBullet> bullets;
    static ArrayList<PlayerBulletA> bullet1s;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        bullets = new ArrayList<>();
        bullet1s = new ArrayList<>();
    }

    public void run() {
        long delay = 1000/60;
        long lastTime = 0;
        while (true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay){
                this.player.run();
                this.background.run();
                for (int i =0; i<bullets.size(); i++){
                    bullets.get(i).run();
                }
                for (int i =0; i<bullet1s.size(); i++){
                    bullet1s.get(i).run();
                }
                this.repaint(); // ~paint
                lastTime = currentTime;
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,settings.screen_width,settings.screen_height);
        this.background.render(g);
        this.player.render(g);
        for (int i=0; i<bullets.size();i++){
            bullets.get(i).render(g);
        }
        for (int i=0; i<bullet1s.size();i++) {
            bullet1s.get(i).render(g);
        }
    }
}
