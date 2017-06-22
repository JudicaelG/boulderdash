package model;

import controller.KeyManager;
import view.Camera;

public class Handler {
// ATTRIBUTES
    private Game game;
    private World world;


// GETTERS AND SETTERS
    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    public World getWorld() { return world; }
    public void setWorld(World world) { this.world = world; }

    public int getWidth() { return game.getWidth(); }
    public int getHeight() { return game.getHeight(); }

    public KeyManager getKeyManager() { return game.getKeyManager();}

    public Camera getCamera() { return game.getCamera(); }


// CONSTRUCTOR
    public Handler(Game game) {
        this.game = game;
    }
}
