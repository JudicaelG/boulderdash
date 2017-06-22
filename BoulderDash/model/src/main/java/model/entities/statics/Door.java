package projet.model.entities.statics;

import projet.model.Handler;
import projet.view.Assets;
import projet.model.Tile;

import java.awt.*;

public class Door extends StaticEntity {

    public Door(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.door, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
}
