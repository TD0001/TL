package game;

public class FrameCounter {
    int countMax;
    int count;

    public FrameCounter(int countMax){
        this.countMax = countMax;
        this.count = 0;
    }
    public boolean count(){
        if (count>= countMax){
            return true;
        }else {
            this.count++;
            return false;
        }
    }
    public void reset(){
        this.count = 0;

    }
}
