package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Renderer;
import tklibs.vector2D;

import javax.swing.*;

public class GameObject {
    // static - quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> topLayer = new ArrayList<>();
    public static ArrayList<GameObject> midLayer = new ArrayList<>();
    public static ArrayList<GameObject> botLayer = new ArrayList<>();

    public static <E extends GameObject> E findIntersects(Class<E> clazz, BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            // object.active
            // object instanceof clzz
            // object instanceof Physics
            // object.getBoxCollider().intersects(boxCollider)
            if (object.active && clazz.isAssignableFrom(object.getClass())
                    && object instanceof Physics && ((Physics) object).getBoxCollider().intersects(boxCollider)) {
                return (E) object;
            }
        }
        return  null;
    }
    public static <E extends GameObject> E findInactive(Class<E> clazz) {
        for (int i=0;i< gameObjects.size(); i++){
            GameObject object = gameObjects.get(i);
            if (!object.active && clazz.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }
    // E extends GameObject
    public static <E extends GameObject> E recycleGameObjects(Class<E> clazz){
        //clazz = Player.class; E = player
        // findInactive if true then return
        //else creat
        E inactiveGameObject = findInactive(clazz);
        if (inactiveGameObject != null){
            inactiveGameObject.reset();
            return inactiveGameObject;
        }
        try {
            E gameObject = clazz.newInstance(); // new E();
//            cach viet moi: clazz.getConstructor().newInstance()
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex){
            return null;
        }
    }
    public static void clearAll(){
        gameObjects.clear();
        topLayer.clear();
        midLayer.clear();
        botLayer.clear();
    }
    public static void runAll(){
        System.out.println(">");
        for (int i = 0; i < gameObjects.size();i++){
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.active){
                gameObject.run();
            }
        }
    }
    public static void renderAll(Graphics g){
        for (int i =0;i < botLayer.size(); i++){
            GameObject gameObject = botLayer.get(i);
            if (gameObject.active){
                gameObject.render(g);
            }
        }
        for (int i =0;i < midLayer.size(); i++){
            GameObject gameObject = midLayer.get(i);
            if (gameObject.active){
                gameObject.render(g);
            }
        }
        for (int i =0;i < topLayer.size(); i++){
            GameObject gameObject = topLayer.get(i);
            if (gameObject.active){
                gameObject.render(g);
            }
        }
    }
    //thuoc tinh
    public BufferedImage image;
    public vector2D position;
    public vector2D velocity;
    public Renderer renderer;
    public boolean active;
    public vector2D anchor;

    //ham tao
    public GameObject(){
        this.position = new vector2D();
        this.velocity = new vector2D();
        this.active = true;
        this.anchor = new vector2D(0.5f,0.5f); // f: float
    }
    // phuong thuc
    public void run(){
        this.position.addThis(this.velocity);
    }
    public void render(Graphics g){
        this.renderer.render(g, this);
    }
    public void destroy() {
        this.active = false;
    }
    public void reset(){
        this.active = true;
    }
}
// tim hieu ve generic:  Class, Type, player.class, player.render