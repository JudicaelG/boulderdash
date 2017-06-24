package projet.view;

import java.awt.image.BufferedImage;

public class Animation {
// ATTRIBUTES
/**
 * The speed of the animation
 */
    private int speed;

/**
 * The index of the sprite in the sprites table used for the animations
 */
    private int index;

/**
 * The name of the sprites table
 */
    private BufferedImage[] frames;

/**
 * They are used used to determine the speed
 */
    private long lastTime, timer;

// CONSTRUCTOR
    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }


// METHODS
/**
 * Determines how often the animation is done
 */
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) { index = 0; }
        }
    }

/**
 * Gets the current sprite in the animation
 *
 * @return The current frame in the animation
 */
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}



