package projet.view;

import java.awt.*;

public class Text {
    public static void drawString(Graphics g, String text, int xPos, int yPos, Color color, Font font) {
        g.setColor(color);
        g.setFont(font);

        g.drawString(text, xPos, yPos);
    }
}