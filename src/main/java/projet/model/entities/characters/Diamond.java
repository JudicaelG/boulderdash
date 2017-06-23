package projet.model.entities.characters;

import projet.model.Handler;
import projet.view.Animation;
import projet.view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Diamond extends Character {

    public Diamond(Handler handler, float x, float y) {
        super(handler, x, y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);
        anim_Diamond = new Animation(100, Assets.diamond);
        bounds.x = 2;
        bounds.y = 2;
        bounds.width = 44;
        bounds.height = 44;
        yMove = 1;
    }
    
    @Override
    public void tick() {
        anim_Diamond.tick();
        move();
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
