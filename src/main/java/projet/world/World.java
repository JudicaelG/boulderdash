package projet.world;

import projet.Handler;
import projet.Utils;
import projet.entitites.Entity;
import projet.entitites.EntityManager;
import projet.entitites.characters.Player;
import projet.entitites.statics.Mud;
import projet.entitites.statics.MudNone;
import projet.entitites.statics.Rock;
import projet.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class World {

// ATTRIBUTES
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    // Entities
    private EntityManager entityManager;
    private ArrayList<Entity> entities;
    public ArrayList<Entity> getEntities() { return entities; }
    public Entity entity;


// GETTERS AND SETTERS
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int[][] getTiles() { return tiles; }
    public EntityManager getEntityManager() { return entityManager; }


// CONSTRUCTOR
    public World(Handler handler, String path) {
        this.handler = handler;

        loadWorld(path);
        entityManager = new EntityManager(handler, new Player(handler, 0, 0));
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (tiles[i][j] == 1) { entityManager.addEntity(new Mud(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
                if (tiles[i][j] == 2) { entityManager.addEntity(new MudNone(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
                if (tiles[i][j] == 3) { entityManager.addEntity(new Rock(handler, i * Tile.TILEWIDTH, j * Tile.TILEHEIGHT)); }
            }
        }
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        entityManager.addEntity(new Player(handler, 144, 144));
    }


// METHODS
    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        // rendering efficiency (renders only tiles the player can see)
        int xStart = (int)Math.max(0, handler.getCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int)Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int)Math.max(0, handler.getCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int)Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        // display
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getCamera().getxOffset()), (int)(y * Tile.TILEHEIGHT - handler.getCamera().getyOffset()));
            }
        }
        entityManager.render(g);

        // entities
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x>= width || y >= height) { return Tile.mud_noneTile; }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) { return Tile.mud_noneTile; } // display mudTile if tile is null}
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

