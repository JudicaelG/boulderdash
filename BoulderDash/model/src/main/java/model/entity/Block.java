package model.entity;

import model.BoulderDashModel;

public abstract class Block implements IBlock{
	
	private static int SPEED = 2;
	private static int WIDTH = 32;
	private static int HEIGHT = 32;
	
	public Block(BoulderDashModel boulderDashModel, float x, float y, int tilewidth, int tileheight) {
		// TODO Auto-generated constructor stub
	}
	public void crush(Alive alive){
		
	}
	public void slide (Direction direction){
		
	}
	public void fall(){
		
	}
	public void setDirection (Direction direction){
		
	}
	public Direction getDirection (){
		return null;
		
	}
	
}
