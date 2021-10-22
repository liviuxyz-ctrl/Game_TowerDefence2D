package main;

import java.util.Random;
import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel {
    public GameScreen(){

    }

    private Color getRndColor(){
        Random random =  new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r,g,b);
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);


        for (int y = 0;y < 20;y++)
        {
            for (int x = 0;x < 20;x++){
            g.setColor(getRndColor());
            g.fillRect(32*x, 32*y, 32, 32);
            }
        }


    }
}
