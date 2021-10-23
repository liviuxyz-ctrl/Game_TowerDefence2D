package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Render {
    private Game game;
    private  BufferedImage img;
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    public Render(Game game) {
        this.game = game;
        random = new Random();
        importImg();
        loadSprites();
    }

    public void render(Graphics g){
        switch(GameStates.gameState){
            case MENU :
                for (int y = 0;y < 20;y++)
                {
                    for (int x = 0;x < 20;x++){
                        g.drawImage(sprites.get(getRndInt()), x*32, y*32, null);

                    }
                }
                break;

        }
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


}
