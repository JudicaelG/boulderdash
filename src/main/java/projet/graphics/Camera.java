package projet.graphics;

import projet.Handler;
import projet.entitites.Entity;
import projet.tiles.Tile;

public class Camera {
// ATTRIBUTES
    private Handler handler;
    private float xOffset, yOffset;


// GETTERS AND SETTERS
    public float getxOffset() { return xOffset; }
    public void setxOffset(float xOffset) { this.xOffset = xOffset; }

    public float getyOffset() { return yOffset; }
    public void setyOffset(float yOffset) { this.yOffset = yOffset; }


// CONSTRUCTOR
    public Camera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


    // METHODS
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getWidth()/2;
        checkBlankSpace();
    }

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

}
