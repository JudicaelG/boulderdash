package model.entity;

import model.BoulderDashModel;
import projet.graphics.Animation;  //Bug because I need View
import projet.graphics.Assets; //SAME HERE

public class Player extends Alive {
	
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
	public void dig(Direction direction){
		
	}
	public void push (Direction direction){
		
	}
	public void pickUp(){
		
	}
	public void leave(){
		
	}
}
