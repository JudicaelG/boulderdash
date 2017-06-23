package projet.model;

import projet.view.Assets;

import java.awt.*;

public class WinState extends State {

    public WinState(Handler handler) {
        super(handler);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.winScreen, 0, 0, 768, 768, null);
    }
}
