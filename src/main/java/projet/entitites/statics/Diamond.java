package projet.entitites.statics;

import projet.Handler;
import projet.graphics.Assets;
import projet.tiles.Tile;

import java.awt.*;

public class Diamond extends StaticEntity {

    public Diamond(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.diamond1, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean collectableEntity() { return true; }
}
