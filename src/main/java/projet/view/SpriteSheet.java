package projet.view;

import java.awt.image.BufferedImage;



public class SpriteSheet {
    private BufferedImage sheet;

/**
 * Gets the sheet
 *
 * @param sheet
 * The sheet that has to be loaded
 */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }


/**
 * Crops sprites from a sheet
 *
 * @param x
 * The x position of the sprite
 * @param y
 * The y position of the sprite
 * @param width
 * The width of the sprite
 * @param height
 * The height of the sprite
 *
 * @return The sprite
 */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
