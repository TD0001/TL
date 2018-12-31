package game;

import tklibs.vector2D;

public class Rectangle {
    vector2D position;
    int width;
    int height;

    public Rectangle(vector2D position, int width, int height){
        this.position = position;
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
    public boolean intersects(Rectangle other){
        //todo


        return this.top() <= other.bot() && this.bot() >= other.top() && this.left() <= other.right()
                && this.right() >= other.left();
    }
    public static void main(String[] args){
        Rectangle rect1 = new Rectangle(new vector2D(0,0), 5,5);
        Rectangle rect2 = new Rectangle(new vector2D(6,6), 5,5);
        Rectangle rect3 = new Rectangle(new vector2D(3,3), 5,5);
        System.out.println(rect3.intersects(rect2));
    }
}
