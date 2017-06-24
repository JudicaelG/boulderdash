package projet.entities.statics;

import projet.game.Handler;
import projet.view.Assets;
import tiles.Tile;

import java.awt.*;

public class Mud extends StaticEntity {

    public Mud(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        health = 1000000000;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mud, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean breakableEntity() {
        return true;
    }
}
