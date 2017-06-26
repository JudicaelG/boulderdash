package projet.view;

import projet.game.Handler;
import projet.entities.Entity;
import projet.tiles.Tile;

public class Camera {
    // ATTRIBUTES
    private Handler handler;
    private float xOffset, yOffset;


// GETTERS AND SETTERS

    /**
     * Gets the xOffset of the camera
     *
     * @return The xOffset
     */
    public float getxOffset() {
        return xOffset;
    }


    /**
     * Gets the yOffset of the camera
     *
     * @return The yOffset
     */
    public float getyOffset() {
        return yOffset;
    }


    // CONSTRUCTOR
    public Camera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


    // METHODS

    /**
     * Moves the camera
     * Adds x and y amount to x and y Offset
     *
     * @param xAmt The amount of x the camera has to move
     * @param yAmt The amount of y the camera has to move
     */
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }


    /**
     * Checks the blank spaces in the Map to not display them
     */
    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }


    /**
     * Centers the camera on an entity (the player)
     *
     * @param e The entity the camera has to center
     */
    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getWidth() / 2;
        checkBlankSpace();
    }
}
