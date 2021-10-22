package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame {

    private BufferedImage img;
    private final double timePerFrame;
    private long lastFrame;

    private final double timePerUpdate;
    private long lastUpdate;
    private int updates;
    private long lastTimeUPS;



    //Constructor
    public Game(){
        timePerFrame = 10.00E8 / 120;
        timePerUpdate = 10.00E8 / 60;
        importImg();
        setSize(640, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        GameScreen gameScreen = new GameScreen(img);
        add(gameScreen);
        setVisible(true);

    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/atlas.png");

        try {
            assert is != null;
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loopGame(){
        while (true) {
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
                callUPS();
            }
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                lastFrame = System.nanoTime();
                repaint();
            }
        }
    }

    private void callUPS() {
        if(System.currentTimeMillis()- lastTimeUPS >= 1000){
            System.out.println("UPS:" + updates );
            updates =0;
            lastTimeUPS = System.currentTimeMillis();

        }
    }

    private void updateGame() {
        updates++;
        lastUpdate = System.nanoTime();
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.loopGame();
    }
}
