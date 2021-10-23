package main.helperMethods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;



public class LoadSave {

    public static BufferedImage getSpriteAltlas(){

        BufferedImage img = null;
        InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("res/atlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;

    }
}
