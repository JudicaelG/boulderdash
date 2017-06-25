package projet.game.states;

import projet.view.Assets;
import projet.game.Handler;

import java.awt.*;

public class WinState extends State {

    public WinState(Handler handler) {
        super(handler);
    }

    public void tick() {

    }

/**
 * Displays the "YOU WIN" image
 */
    public void render(Graphics g) {
        g.drawImage(Assets.winScreen, 0, 0, 768, 768, null);
    }
}
