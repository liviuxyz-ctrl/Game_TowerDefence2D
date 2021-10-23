package main.handlers;

import main.helperMethods.LoadSave;
import main.objects.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Handlers(helps)
//Handlers(helps)
public class TileManager {

    public final int CONST_SIZE = 32;
    public Tile GRASS,WATER,ROAD;
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<Tile>();

    public TileManager(){
        loadAtlas();
        createTiles();
    }

    private void createTiles() {
        tiles.add(GRASS = new Tile(getSprite(8,1))); //ID 0
        tiles.add(WATER = new Tile(getSprite(0,6))); //ID 1
        tiles.add(ROAD  = new Tile(getSprite(9,0))); //ID 2
    }

    private void loadAtlas() {

        atlas = LoadSave.getSpriteAltlas();

    }

    public BufferedImage getSprite(int id){
        return tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int xCord, int yCord){
        return atlas.getSubimage(xCord* CONST_SIZE,yCord*CONST_SIZE ,32, 32);
    }
}
