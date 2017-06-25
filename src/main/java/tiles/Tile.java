package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
// TILES
    public static Tile[] tiles = new Tile[256];
    public static Tile wallTile = new WallTile(0);
    public static Tile mudTile = new MudTile(1);
    public static Tile mud_noneTile = new MudNoneTile(2);
    public static Tile diamondTile = new DiamondTile(3);
    public static Tile rockTile = new RockTile(4);
    public static Tile monsterTile = new MonsterTile(8);

// ATTRIBUTES
/**
 * The width of the tiles
 */
    public static final int TILEWIDTH = 48;

/**
 * The height of the tiles
 */
    public static final int TILEHEIGHT = 48;

/**
 * The texture of the tile
 */
    protected BufferedImage texture;

/**
 * The id of the tile used to replace it by an element
 */
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

/**
 * Checks if an element is solid or not (default false)
 *
 * @return True if solid / False if not
 */
    public boolean isSolid() { return false; }
}
