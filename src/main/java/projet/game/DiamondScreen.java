package projet.game;

import projet.view.Assets;

import java.awt.*;

public class DiamondScreen {

    public void tick() {

    }
    public void render(Graphics g) {
        g.drawImage(Assets.diamondScreen, 0, 0, 576, 48, null);
    }
}
