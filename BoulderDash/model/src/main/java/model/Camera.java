package model;

import model.entity.Alive;
import model.Tile.Tile;

public class Camera {
	// ATTRIBUTES
    private BoulderDashModel boulderDashModel;
    private float xOffset, yOffset;


// GETTERS AND SETTERS
    public float getxOffset() { return xOffset; }
    public void setxOffset(float xOffset) { this.xOffset = xOffset; }

    public float getyOffset() { return yOffset; }
    public void setyOffset(float yOffset) { this.yOffset = yOffset; }


// CONSTRUCTOR
    public Camera(BoulderDashModel boulderDashModel, float xOffset, float yOffset) {
        this.boulderDashModel = boulderDashModel;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


    // METHODS
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public void centerOnEntity(Alive e) {
        xOffset = e.getX() - boulderDashModel.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - boulderDashModel.getHeight()/2 + e.getWidth()/2;
        checkBlankSpace();
    }

    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > BoulderDashModel.getMap().getWidth() * Tile.TILEWIDTH - boulderDashModel.getWidth()) {
            xOffset = BoulderDashModel.getMap().getWidth() * Tile.TILEWIDTH - boulderDashModel.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > BoulderDashModel.getMap().getHeight() * Tile.TILEHEIGHT - boulderDashModel.getHeight()) {
            yOffset = BoulderDashModel.getMap().getHeight() * Tile.TILEHEIGHT - boulderDashModel.getHeight();
        }
    }

}