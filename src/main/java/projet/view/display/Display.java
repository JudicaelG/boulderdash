package projet.view.display;

import javax.swing.*;
import java.awt.*;

public class Display {
// ATTRIBUTES
/**
 * The frame of the game
 */
    private JFrame frame;

/**
 * The canvas to display
 */
    private Canvas canvas;

/**
 * The title of the window
 */
    private String title;

/**
 * The width of the window
 */
    private int width;

/**
 * The height of the window
 */
    private int height;


// CONSTRUCTOR
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }


// METHODS
/**
 * Creates the Frame to display the window of the game
 * Creates the Canvas to display elements on the game
 */
    private void createDisplay() {
        // frame
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false); // avoid bugs

        frame.add(canvas);
        frame.pack();
    }

/**
 * Gets the canvas of the game
 *
 * @return The canvas used
 */
    public Canvas getCanvas() { return canvas; }

/**
 * Gets the frame of the game
 *
 * @return The frame used
 */
    public JFrame getFrame() { return frame; }
}
