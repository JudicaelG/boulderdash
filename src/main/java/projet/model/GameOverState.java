package projet.model;

import projet.view.Assets;

import java.awt.*;

public class GameOverState extends State {

    public GameOverState(Handler handler) {
        super(handler);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.gameOverScreen, 0, 0, 768, 768, null);
    }
}
