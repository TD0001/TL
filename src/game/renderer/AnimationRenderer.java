package game.renderer;

import game.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int CurrentImageIndex;
    public AnimationRenderer(ArrayList<BufferedImage> images){
        this.images = images;
        this.CurrentImageIndex =0;
    }
    // TODO: continue editing
    int count = 0;
    @Override
    public void render(Graphics g, GameObject master){
        BufferedImage CurrentImage = this.images.get(this.CurrentImageIndex);
        g.drawImage(CurrentImage, (int)master.position.x,(int)master.position.y, null);
        this.count++;
        if (this.count >10) {
            this.CurrentImageIndex++;
            if (this.CurrentImageIndex >= this.images.size()) {
                this.CurrentImageIndex = 0;
            }
            this.count=0;
        }
    }
}
