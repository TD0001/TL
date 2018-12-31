package game.physics;

import game.GameObject;

import tklibs.vector2D;

public class BoxCollider {
    vector2D position;
    vector2D anchor;
    int width;
    int height;

    public BoxCollider(GameObject object,  int width, int height){
        this.position = object.position;
        this.anchor = object.anchor;
        this.width = width;
        this.height = height;
    }
    public float top(){
        return position.y;
    }
    public float bot() {
        return this.top() + this.height;
    }
    public float left() {
        return this.position.x;
    }
    public float right(){
        return this.left() +this.width;
    }
    public boolean intersects(BoxCollider other) {
        //todo


        return this.top() <= other.bot() && this.bot() >= other.top() && this.left() <= other.right()
                && this.right() >= other.left();
    }
}
