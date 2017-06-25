package projet.game;

import projet.input.KeyManager;
import projet.view.Camera;

public class Handler {
// ATTRIBUTES
/**
 * The game
 */
    private Game game;

/**
 * The world
 */
    private World world;


// GETTERS AND SETTERS
/**
 * Gets the world of the game
 *
 * @return The world
 */
    public World getWorld() { return world; }

    /**
     * Sets the world of the game
     *
     * @param world The world that has to be loaded
     */
    public void setWorld(World world) {
        this.world = world;
    }
/**
 * Gets the width of the game
 *
 * @return The width of the game
 */
    public int getWidth() { return game.getWidth(); }

/**
 * Gets the height of the game
 *
 * @return The height of the game
 */
    public int getHeight() { return game.getHeight(); }


/**
 * Gets the key manager to watch inputs of the player
 *
 * @return The KeyManager of the game
 */
    public KeyManager getKeyManager() { return game.getKeyManager();}


/**
 * Gets the camera of the game
 *
 * @return The camera of the game
 */
    public Camera getCamera() { return game.getCamera(); }


// CONSTRUCTOR
    public Handler(Game game) {
        this.game = game;
    }

}
