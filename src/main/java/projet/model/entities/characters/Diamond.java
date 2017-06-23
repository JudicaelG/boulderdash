package projet.model.entities.characters;

import projet.model.Handler;
import projet.model.entities.statics.StaticEntity;
import projet.view.Animation;
import projet.view.Assets;
import projet.model.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Diamond extends StaticEntity {

    public Diamond(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        anim_Diamond = new Animation(100, Assets.diamond);
    }

    @Override
    public void tick() {
        anim_Diamond.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean collectableEntity() { return true; }

    // Animations
    private Animation anim_Diamond;
    private BufferedImage getCurrentAnimation() { return anim_Diamond.getCurrentFrame(); }
}
