package model.Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile TILES;
	private boolean isSolid;
	private boolean isBreakable;
	// Update 19/06/2017
	public static final int TILEWIDTH = 48;
	public static final int TILEHEIGHT = 48;
	
	
	public static Tile[] tiles = new Tile[256];
    public static Tile mudTile = new MudTile(0);
    public static Tile wallTile = new WallTile(1);



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
	/*public void render(Graphics g, int i, int j) {
		// TODO Auto-generated method stub
		
	}*/
	
	

