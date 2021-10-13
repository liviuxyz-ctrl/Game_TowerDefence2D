package main;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    public GameScreen(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(50,50,100,100);

    }
}
