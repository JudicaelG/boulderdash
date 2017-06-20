package projet.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
// TILES
    public static Tile[] tiles = new Tile[256];
    public static Tile wallTile = new WallTile(0);
    public static Tile mudTile = new MudTile(1);
    public static Tile mud_noneTile = new MudNoneTile(2);
    public static Tile rockTile = new RockTile(3);

// ATTRIBUTES
    public static final int TILEWIDTH = 48;
    public static final int TILEHEIGHT = 48;

    protected BufferedImage texture;
    protected final int id;


// CONSTRUCTOR
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }


// GETTERS AND SETTERS
    public int getId() { return id; }


// METHODS
    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() { return false; }
}
