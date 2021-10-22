package main;

import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage img;
    public GameScreen(BufferedImage img){
        this.img = img;
        Random random =  new Random();
    }

    private Color getRndColor(){

        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);





//        g.setColor(Color.RED);
//
//
//        for (int y = 0;y < 20;y++)
//        {
//            for (int x = 0;x < 20;x++){
//            g.setColor(getRndColor());
//            g.fillRect(32*x, 32*y, 32, 32);
//            }
        }


    }

