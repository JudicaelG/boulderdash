package projet.game.states;

import projet.entities.Entity;
import projet.game.DiamondScreen;
import projet.game.Score;
import projet.view.Assets;
import projet.game.Handler;
import projet.view.Text;

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
        DiamondScreen diamondScreen = new DiamondScreen();
        diamondScreen.render(g);
        Text.drawString(g, Integer.toString(Entity.getDiamondCount()), 16, 32, Color.white, Assets.roboto);
        Text.drawString(g, Integer.toString(Entity.getLastTime()), 216, 32, Color.red, Assets.roboto);
        Text.drawString(g, Integer.toString(Score.getScore()), 416, 32, Color.red, Assets.roboto);
    }
}
