package projet.model.entities.statics;

import projet.model.Handler;
import projet.view.Assets;
import projet.model.Tile;

import java.awt.*;

public class SpecialWall extends StaticEntity {

    public SpecialWall(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.wall_special, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
}
