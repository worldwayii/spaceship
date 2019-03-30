package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageJPanel extends JPanel {

    private String imagePath;



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setSize(100, 100);
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            String path = imagePath != null && !imagePath.isEmpty() ? imagePath : "images/ship.png";
            image = ImageIO.read(new File(path));
            g.drawImage(image, 0, 0, 50, 50, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
