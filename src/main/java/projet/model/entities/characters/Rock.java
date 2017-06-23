package projet.model.entities.characters;

import projet.model.Handler;
import projet.view.Animation;
import projet.view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Rock extends Character {

    public Rock(Handler handler, float x, float y) {
        super(handler, x,y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);
        anim_Rock = new Animation(100, Assets.rock);
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


   /*private void fall() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 48;
        ar.width = arSize;
        ar.height = arSize;

        /f (yMove >= 1) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else { return; }

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) { continue; }
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xOffset, yOffset)) {
                if (e.isPlayer()) { e.die(); }
            }
        }
    }*/
}