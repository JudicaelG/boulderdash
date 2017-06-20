package projet.entitites.characters;

import projet.Handler;
import projet.graphics.Animation;
import projet.graphics.Assets;

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
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 47;
        bounds.height = 47;


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
        handler.getCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) { yMove = -speed; }
        if (handler.getKeyManager().down) {yMove = speed; }
        if (handler.getKeyManager().left) { xMove = -speed; }
        if (handler.getKeyManager().right) { xMove = speed; }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);

        /* HITBOX g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);*/
    }
}