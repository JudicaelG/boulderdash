package model;

import java.awt.Graphics;

import model.Tile.Tile;
import model.entity.Player;
import model.entity.Rock;

public class Map implements IMap {

	
	public Map(){
		
	}
	 public BoulderDashModel boulderDashModel;
	 private int width, height;
	 private int spawnX, spawnY;
	 private int[][] tiles;

	 // Entities
	 private AliveManager aliveManager;

	 // GETTERS AND SETTERS
	 public int getWidth() { return width; }
	 public int getHeight() { return height; }


	// CONSTRUCTOR
	public Map(BoulderDashModel boulderDashModel, String path) {
	    this.boulderDashModel = boulderDashModel;
	    aliveManager = new AliveManager(boulderDashModel, new Player(boulderDashModel, 0, 0));
	    aliveManager.addEntity(new Rock(boulderDashModel, 256, 256));

	    loadWorld(path);

	    AliveManager.getPlayer().setX(spawnX);
	    AliveManager.getPlayer().setY(spawnY);
	}


	// METHODS
	public void tick() {
	    AliveManager.tick();
	}

	public void render(Graphics g) {
	   // rendering efficiency (renders only tiles the player can see)
	   int xStart = (int)Math.max(0, boulderDashModel.getCamera().getxOffset() / Tile.TILEWIDTH);
	   int xEnd = (int)Math.min(width, (boulderDashModel.getCamera().getxOffset() + boulderDashModel.getWidth()) / Tile.TILEWIDTH + 1);
	   int yStart = (int)Math.max(0, boulderDashModel.getCamera().getyOffset() / Tile.TILEHEIGHT);
	   int yEnd = (int)Math.min(height, (boulderDashModel.getCamera().getyOffset() + boulderDashModel.getHeight()) / Tile.TILEHEIGHT + 1);

	   // display
	   for (int y = yStart; y < yEnd; y++) {
	       for (int x = xStart; x < xEnd; x++) {
	           getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - boulderDashModel.getCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT - boulderDashModel.getCamera().getyOffset()));
	       }
	   }

	   // entities
	   AliveManager.render(g);
	}

	public Tile getTile(int x, int y) {
	   if (x < 0 || y < 0 || x>= width || y >= height) { return Tile.mudTile; }

	   	Tile t = Tile.tiles[tiles[x][y]];
	    if (t == null) { return Tile.mudTile; } // display mudTile if tile is null}
	    return t;
	}

	private void loadWorld(String path) {
	   String file = Utils.loadFileAsString(path);
	   String[] tokens = file.split("\\s+"); // separates every character
	   width = Utils.parseInt(tokens[0]);
	   height = Utils.parseInt(tokens[1]);
	   spawnX = Utils.parseInt(tokens[2]);
	   spawnY = Utils.parseInt(tokens[3]);

	   tiles = new int[width][height];
	   for (int y = 0; y < height; y++) {
	       for (int x = 0; x < width; x++) {
	          tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
	       }
	   }
	}
	
}
