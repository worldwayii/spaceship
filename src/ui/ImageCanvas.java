package ui;

import java.awt.*;

public class ImageCanvas extends Canvas {


    private String imagePath;

    public ImageCanvas(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void paint(Graphics g) {
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(imagePath);
        g.drawImage(i, 120,120,this);
    }
}
