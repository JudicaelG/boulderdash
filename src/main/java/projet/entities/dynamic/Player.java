package projet.entities.dynamic;

import projet.game.DiamondScreen;
import projet.game.states.GameOverState;
import projet.game.Handler;
import projet.game.states.State;
import projet.view.Animation;
import projet.view.Assets;
import projet.view.Text;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends DynamicEntity {
// ANIMATIONS
/**
 * Every animations of the player
 */
    private Animation anim_PlayerAFK, anim_PlayerLeft, anim_PlayerUp, anim_PlayerRight, anim_PlayerDown;

/**
 * Changes the sprite depending on the movement of the player
 *
 * @return The current frame of the different frames composing the animation
 */
    private BufferedImage getCurrentAnimation() {
        if( xMove < 0) { return anim_PlayerLeft.getCurrentFrame(); }
        else if( xMove > 0) { return anim_PlayerRight.getCurrentFrame(); }
        else if( yMove < 0) { return anim_PlayerUp.getCurrentFrame(); }
        else if( yMove > 0) { return anim_PlayerDown.getCurrentFrame(); }
        else { return anim_PlayerAFK.getCurrentFrame();}
    }

// CONSTRUCTOR
/**
 * Sets the hitbox and the animations of the player
 *
 * @param handler The handler of the game
 *
 * @param x The x position of the player
 *
 * @param y The y position of the player
 */
    public Player(Handler handler, float x, float y) {
        super(handler, x,y, DEFAULT_CHARACTER_WIDTH, DEFAULT_CHARACTER_HEIGHT);

        //HITBOX
        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 42;


        // Animations
        anim_PlayerAFK = new Animation(500, Assets.player_afk);
        anim_PlayerLeft = new Animation(150, Assets.player_left);
        anim_PlayerUp = new Animation(150, Assets.player_up);
        anim_PlayerRight = new Animation(150, Assets.player_right);
        anim_PlayerDown = new Animation(150, Assets.player_down);
    }


// METHODS
/**
 * Actualizes the sprites of the player with animations and centers camera on him
 */
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
        /*try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        handler.getCamera().centerOnEntity(this);
        win();
    }

/**
 * Changes xMove and yMove depending on which key is pressed
 */
    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) { yMove = -speed; }
        if (handler.getKeyManager().down) { yMove = speed; }
        if (handler.getKeyManager().left) { xMove = -speed; }
        if (handler.getKeyManager().right) { xMove = speed; }
    }

/**
 * Changes the gameState to gameOverState if the player dies
 */
    public void die() {
        State gameOverState = new GameOverState(handler);
        State.setState(gameOverState);
    }


    public boolean isPlayer() { return true;}


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
        DiamondScreen diamondScreen = new DiamondScreen();
        diamondScreen.render(g);
        Text.drawString(g, Integer.toString(getDiamondCount()), 24, 32, Color.white, Assets.roboto);

        //HITBOX
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);*/
    }
}
