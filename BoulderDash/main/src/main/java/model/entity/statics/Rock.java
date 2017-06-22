package model.entity.statics;

import model.Handler;
import model.Tile;
import view.Animation;
import view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends StaticEntity {

    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        anim_Rock = new Animation(100, Assets.rock);
    }

    @Override
    public void tick() {
        anim_Rock.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean testEntity() { return true; }

    // Animations
    private Animation anim_Rock;
    private BufferedImage getCurrentAnimation() { return anim_Rock.getCurrentFrame(); }
}
