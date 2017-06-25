package projet.game.states;

import projet.view.Assets;
import projet.game.Handler;

import java.awt.*;

public class GameOverState extends State {

    public GameOverState(Handler handler) {
        super(handler);
    }

    public void tick() {

    }

/**
 * Displays the "GAME OVER" image
 */
    public void render(Graphics g) {
        g.drawImage(Assets.gameOverScreen, 0, 0, 768, 768, null);
    }
}
