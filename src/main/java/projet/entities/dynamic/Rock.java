package projet.entities.dynamic;

import projet.game.Handler;
import projet.view.Animation;
import projet.view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends DynamicEntity {

    public Rock(Handler handler, float x, float y) {
        super(handler, x,y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);
        anim_Rock = new Animation(500, Assets.rock);
        bounds.x = 2;
        bounds.y = 2;
        bounds.width = 44;
        bounds.height = 44;
        yMove = 1;
    }

    @Override
    public void tick() {
        anim_Rock.tick();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    @Override
    public boolean isRock() { return true; }

    // Animations
    private Animation anim_Rock;
    private BufferedImage getCurrentAnimation() { return anim_Rock.getCurrentFrame(); }
}
