package main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel {

    private Random random;
    private final BufferedImage img;
    private Dimension size;
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();





    public GameScreen(BufferedImage img){

        Random random =  new Random();
        this.img = img;
        setPanelSize();
        //Don't call the methods until you use your constructor genius
        loadSprites();

    }

    private void setPanelSize() {
        size = new Dimension(640,640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void loadSprites() {

        for(int y=0; y<10;y++){
            for(int x=0; x<10;x++){
                try {
                    sprites.add(img.getSubimage(x*32,y*32,32,32));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private int getRndInt(){
        Random random =  new Random();
        return random.nextInt(100);
    }

    private Color getRndColor(){

        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // g.drawImage(img, 0, 0, null);
        //        BufferedImage orc = img.getSubimage(32*9,32,32,32);
        //        g.drawImage(orc, 0, 0, null);
        //   g.drawImage(sprites.get(19), 0, 0, null);

        g.setColor(Color.RED);


        for (int y = 0;y < 20;y++)
        {
            for (int x = 0;x < 20;x++){
               g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);

            }
        }





    }


}

