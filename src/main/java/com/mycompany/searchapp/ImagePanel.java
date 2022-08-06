package com.mycompany.searchapp;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("pictures\\i1.jpg"));
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    public void paintComponent(Graphics g) {//,Panel f
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}