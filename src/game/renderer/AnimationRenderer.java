package game.renderer;

import game.FrameCounter;
import game.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int CurrentImageIndex;
    boolean isOne;
    FrameCounter nextImageCounter;



    public AnimationRenderer(ArrayList<BufferedImage> images){
        this(images, false, 10);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images, boolean isOne){
        this(images, isOne,10);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images, boolean isOne,
                             int nextImagesCount){
        this.images = images;
        this.isOne =  isOne;
        this.nextImageCounter = new FrameCounter(nextImagesCount);
    }
    // TODO: continue editing

    @Override
    public void render(Graphics g, GameObject master){
        BufferedImage CurrentImage = this.images.get(this.CurrentImageIndex);
        g.drawImage(CurrentImage,
                (int)(master.position.x - CurrentImage.getWidth() * master.anchor.x),
                (int)(master.position.y - CurrentImage.getHeight() * master.anchor.y), null);

        if (this.nextImageCounter.count()) {
            this.CurrentImageIndex++;
            //todo
            if(this.isOne && this.CurrentImageIndex >= this.images.size()){
                master.destroy();
            }
            if (this.CurrentImageIndex >= this.images.size()) {
                this.CurrentImageIndex = 0;
            }
            this.nextImageCounter.reset();
        }
    }

    @Override
    public void reset() {
        this.CurrentImageIndex = 0;
    }
}
