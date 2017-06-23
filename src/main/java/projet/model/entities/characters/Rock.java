package projet.model.entities.characters;

import projet.model.Handler;
import projet.model.entities.Entity;
import projet.view.Animation;
import projet.view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends Character {

    public Rock(Handler handler, float x, float y) {
        super(handler, x,y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);
        anim_Rock = new Animation(100, Assets.rock);
        yMove = 1;
        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 40;
        bounds.height = 40;
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
    public boolean testEntity() { return true; }

    // Animations
    private Animation anim_Rock;
    private BufferedImage getCurrentAnimation() { return anim_Rock.getCurrentFrame(); }


    private void fall() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (yMove <= -1) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }  if (yMove >= 1) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (xMove <= -1) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (xMove >= 1) {
            ar.x = cb.x + arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else { return; }

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) { continue; }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
            }
        }

    }
}
