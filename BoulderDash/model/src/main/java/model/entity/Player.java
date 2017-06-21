package model.entity;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import model.Assets;
import model.BoulderDashModel;
  //Bug because I need View
 //SAME HERE

public class Player extends Alive {
	
	private Animation anim_PlayerAFK, anim_PlayerLeft, anim_PlayerUp, anim_PlayerRight, anim_PlayerDown;
	public Player(BoulderDashModel boulderDashModel, float x, float y) {
        super(boulderDashModel, x,y, Alive.WIDTH , Alive.HEIGHT);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 48;
        bounds.height = 48;


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
        BoulderDashModel.getCamera().centerOnEntity(this);
    }
    private void getInput() {
        xMove = 0;
        yMove = 0;
    }
 // METHODS
    public void move() {
        MoveX();
        MoveY();
        if (boulderDashModel.getKeyManager().up) { yMove = -SPEED; }
        if (boulderDashModel.getKeyManager().down) {yMove = SPEED; }
        if (boulderDashModel.getKeyManager().left) { xMove = -SPEED; }
        if (boulderDashModel.getKeyManager().right) { xMove = SPEED; }
    }
    private BufferedImage getCurrentAnimation() {
        if( xMove < 0) { return anim_PlayerLeft.getCurrentFrame(); }
        else if( xMove > 0) { return anim_PlayerRight.getCurrentFrame(); }
        else if( yMove < 0) { return anim_PlayerUp.getCurrentFrame(); }
        else if( yMove > 0) { return anim_PlayerDown.getCurrentFrame(); }
        else { return anim_PlayerAFK.getCurrentFrame();}
    }

	
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - BoulderDashModel.getCamera().getxOffset()), (int)(y - BoulderDashModel.getCamera().getyOffset()), width, height, null);
}
}

	
	


