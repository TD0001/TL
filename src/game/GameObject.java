package game;

import java.awt.*;
import java.awt.image.BufferedImage;

import game.renderer.Renderer;
import tklibs.vector2D;

import javax.swing.*;

public class GameObject {
    public BufferedImage image;
    public vector2D position;
    public vector2D velocity;
    public Renderer renderer;


    public GameObject(){
        this.position = new vector2D();
        this.velocity = new vector2D();

    }

    public void run(){
        this.position.addThis(this.velocity);
    }
    public void render(Graphics g){
        this.renderer.render(g, this);
    }
}
