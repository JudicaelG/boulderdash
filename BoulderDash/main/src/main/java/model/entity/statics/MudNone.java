package model.entity.statics;

import model.Handler;
import view.Assets;
import model.Tile;

import java.awt.*;

public class MudNone extends StaticEntity {

    public MudNone(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mud_none, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean solidEntity() {
        return false;
    }
}
