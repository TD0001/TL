package tklibs;

public class vector2D {
    public float x;
    public float y;
    public vector2D(){
        this(0, 0);
    }
    public vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public vector2D addThis(float x, float y){
        this.x +=x;
        this.y +=y;
        return this;
    }
    public vector2D addThis(vector2D other){
        return this.addThis(other.x, other.y);
    }
    public vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
}
    public vector2D clone(){
        return new vector2D(this.x, this.y);
    }
    public vector2D set(vector2D other){
        return this.set(other.x,other.y);
    }
    public vector2D subtractThis(float x, float y){
        this.x -=x;
        this.y -=y;
        return this;
    }
    public vector2D subtractThis(vector2D other) {
        return this.subtractThis(other.x, other.y);
    }
    public vector2D scaleThis(float rate){
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public float getLength(){
        return (float) Math.sqrt(x * x + y * y);
    }

    public vector2D setLength(float length){
        float currentlength = this.getLength();
        if( currentlength !=0) {
            float rate = length / this.getLength();
            return this.scaleThis(rate);
        }
        return this;
    }

    public float getAngle() {
            return (float) Math.atan(this.y/ this.x);


    }
    public vector2D setAngle(float angle) {
        float length = this.getLength();
        this.x = (float) (length * Math.cos(angle));
        this.y = (float) (length * Math.sin(angle));
        return this;
    }

    @Override // ghi de ham trong class con co ten giong ten ham trong class cha
    public String toString() {
        return "tklibs.vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

//    public static void main(String[] args){
//        tklibs.vector2D v1 = new tklibs.vector2D(1,1);
//        System.out.println(v1.setLength((float)Math.sqrt(18)));
//        System.out.println(v1.setAngle((float)-Math.PI/4));
//
//    }
}
