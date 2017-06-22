package projet.model.entities.characters;

import projet.model.Handler;
import projet.model.entities.Entity;
import projet.view.Animation;
import projet.view.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Character {
// ANIMATIONS
    private Animation anim_PlayerAFK, anim_PlayerLeft, anim_PlayerUp, anim_PlayerRight, anim_PlayerDown;
    private BufferedImage getCurrentAnimation() {
        if( xMove < 0) { return anim_PlayerLeft.getCurrentFrame(); }
        else if( xMove > 0) { return anim_PlayerRight.getCurrentFrame(); }
        else if( yMove < 0) { return anim_PlayerUp.getCurrentFrame(); }
        else if( yMove > 0) { return anim_PlayerDown.getCurrentFrame(); }
        else { return anim_PlayerAFK.getCurrentFrame();}
    }

// CONSTRUCTOR
    public Player(Handler handler, float x, float y) {
        super(handler, x,y, Character.DEFAULT_CHARACTER_WIDTH, Character.DEFAULT_CHARACTER_HEIGHT);

        //HITBOX
        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 42;
        bounds.height = 42;


        // Animations
        anim_PlayerAFK = new Animation(500, Assets.player_afk);
        anim_PlayerLeft = new Animation(150, Assets.player_left);
        anim_PlayerUp = new Animation(150, Assets.player_up);
        anim_PlayerRight = new Animation(150, Assets.player_right);
        anim_PlayerDown = new Animation(150, Assets.player_down);
    }


// METHODS
    @Override
    public void tick() {
        // Animation
        anim_PlayerAFK.tick();
        anim_PlayerLeft.tick();
        anim_PlayerUp.tick();
        anim_PlayerRight.tick();
        anim_PlayerDown.tick();

        // Movement
        getInput();
        move();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.getCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) { yMove = -speed; }
        if (handler.getKeyManager().down) { yMove = speed; }
        if (handler.getKeyManager().left) { xMove = -speed; }
        if (handler.getKeyManager().right) { xMove = speed; }
    }


    private void fall() {
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().up) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().down) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().left) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().right) {
            ar.x = cb.x + arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else { return; }

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) { continue; }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                return;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);

        //HITBOX
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);*/
    }

    @Override
    public boolean solidEntity() {
        return false;
    }
}
