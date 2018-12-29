package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isAnyKeyPress;

    GameCanvas canvas;

    public GameWindow() {

        this.setTitle("Tao không vào địa ngục thì ai");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new GameCanvas();
        this.canvas.setPreferredSize(new Dimension(settings.screen_width, settings.screen_height));
        this.add(canvas);
        this.pack();
        this.setupEventListener();
        this.setVisible(true);

    }

    private void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {// new  KeyAdapter   roi an Alt + Enter
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
                if (e.getKeyCode() == KeyEvent.VK_W){
                    GameWindow.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    GameWindow.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    GameWindow.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    GameWindow.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    GameWindow.isFirePress = true;
                }
            }
            // giu phim
            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    GameWindow.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    GameWindow.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    GameWindow.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    GameWindow.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    GameWindow.isFirePress = false;
                }
                // nha phim
            }
        });
    }
}
