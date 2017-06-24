package projet.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {

/**
 * Loads font to display Time and Diamonds
 *
 * @param path
 * The path of the font
 * @param size
 * The font size
 *
 * @return The font created
 */
    public static Font loadFont(String path, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
