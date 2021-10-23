package main;

import main.inputs.MyKeyboardListener;
import main.inputs.MyMouseListener;
import main.scenes.Menu;
import main.scenes.Playing;
import main.scenes.Settings;

import javax.swing.*;

public class Game extends JFrame implements Runnable {

    private static final double FPS_SET = 144;
    private static final double UPS_SET = 60;

    private MyMouseListener myMouseListener;
    private MyKeyboardListener myKeyboardListener;

    //Classes
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;



    //Constructor
    public Game(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        GameScreen gameScreen = new GameScreen(this);
        initClasses();
        add(gameScreen);

        pack();
        setVisible(true);

    }

    public void initClasses() {
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void initInputs(){
        myKeyboardListener = new MyKeyboardListener();
        myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(myKeyboardListener);
        requestFocus();
    }




    private void updateGame() {

    }

    public static void main(String[] args) {

        Game game = new Game();
        game.initInputs();
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

        long currentTime;

        //Render
        while (true){
            // Render
            currentTime = System.nanoTime();
            if (currentTime - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = currentTime;
                frames++;
                }
            // Update
            if(currentTime - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = currentTime;
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

    //Getter and setters
    public Render getRender() {
        return render;
    }

    public void setRender(Render render) {
        this.render = render;
    }
}
