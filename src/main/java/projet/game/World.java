package projet.game;

import projet.entities.Entity;
import projet.entities.EntityManager;
import projet.entities.MobEntity.*;
import projet.entities.dynamic.Diamond;
import projet.entities.dynamic.Player;
import projet.entities.dynamic.Rock;
import projet.entities.statics.Mud;
import projet.entities.statics.Wall;
import projet.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class World {

    // ATTRIBUTES
    private Handler handler;
    /**
     * The width of the window
     */
    private int width;

    /**
     * The height of the window
     */
    private int height;

    /**
     * The x position where the player spawns
     */
    private int spawnX;

    /**
     * The y position where the player spawns
     */
    private int spawnY;

    /**
     * The table where are stocked the id of the map elements
     */
    private int[][] tiles;
    
    
    private static int diamondCount = 0;

    // Entities
    public static EntityManager entityManager;
    private static ArrayList<Entity> entities;
    public ArrayList<Entity> getEntities() { return entities; }
    public Entity entity;
    public Player player;


    // GETTERS AND SETTERS
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int[][] getTiles() { return tiles; }
    public EntityManager getEntityManager() { return entityManager; }


// CONSTRUCTOR
    /**
     * Creates the world and replaces projet.tiles by entities
     *
     * @param handler The handler of the game
     * @param path The path of the map
     */
    public World(Handler handler, String path) {
        this.handler = handler;

        loadWorld(path);
        entityManager = new EntityManager(handler, new Player(handler, 0, 0));
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
            	if (tiles[i][j] == 0) { entityManager.addEntity(new Wall(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
                if (tiles[i][j] == 1) { entityManager.addEntity(new Mud(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
                if (tiles[i][j] == 3) { entityManager.addEntity(new Diamond(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
                if (tiles[i][j] == 4) { entityManager.addEntity(new Rock(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
                if (tiles[i][j] == 5) { entityManager.addEntity(new Spider(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
                if (tiles[i][j] == 6) { entityManager.addEntity(new Bat(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
                if (tiles[i][j] == 7) { entityManager.addEntity(new Wild_Man(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
                if (tiles[i][j] == 8) { entityManager.addEntity(new Squid(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
                if (tiles[i][j] == 9) { entityManager.addEntity(new Butterfly(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); diamondCount++;}
            }
        }
        Entity.setDiamondCount(diamondCount);
        Entity.setMaxTime(diamondCount*10);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        //entityManager.addEntity(new Player(handler, spawnX, spawnY));
    }


    // METHODS
    public void tick() {
        entityManager.tick();
    }

    /**
     * Renders elements
     *
     * @param g A graphic attribute to display elements
     */
    public void render(Graphics g) {
        // rendering efficiency (renders only projet.tiles the player can see)
        int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int)Math.max(0, handler.getCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        // display
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }


    /**
     * Places every projet.tiles at the right position
     *
     * @param x The x Position of the tile
     *
     * @param y The y Position of the tile
     *
     * @return The tile
     */
    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x>= width || y >= height) { return Tile.mud_noneTile; }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) { return Tile.mud_noneTile; } // display mudTile if tile is null}
        return t;
    }


    /**
     * Sets the width, height, x spawn and y spawn of the player mentioned in the txt map and gets every projet.tiles
     *
     * @param path The path to the txt map file
     */
    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); // separates every character
        width = Utils.parseInt(tokens[1]);
        height = Utils.parseInt(tokens[2]);
        spawnX = Utils.parseInt(tokens[3]);
        spawnY = Utils.parseInt(tokens[4]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 5]);
            }
        }
    }
}

