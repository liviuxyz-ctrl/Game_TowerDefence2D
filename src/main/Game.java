package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {

    private static final double FPS_SET = 144;
    private static final double UPS_SET = 60;
    private BufferedImage img;


    //Constructor
    public Game(){
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


    private void updateGame() {

    }

    public static void main(String[] args) {

        Game game = new Game();
        game.start();
    }

    private void start() {
        Thread gameThread = new Thread(this) {};
        gameThread.start();

    }

    @Override
    public void run() {
        final double timePerFrame;
        final double timePerUpdate;
        timePerFrame = 10.00E8 / FPS_SET;
        timePerUpdate = 10.00E8 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        //Render
        while (true){
            // Render
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = System.nanoTime();
                frames++;
                }
            // Update
            if(System.nanoTime() - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }
            // UPS and FPS counter
            if(System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS " + frames + " | UPS "+ updates);
                updates = 0;
                frames = 0;
                lastTimeCheck= System.currentTimeMillis();
            }


        }

        //Update
        //checking ups and fps
    }
}
