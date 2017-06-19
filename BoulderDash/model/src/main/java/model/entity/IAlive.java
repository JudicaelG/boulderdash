package model.entity;

public interface IAlive {

	public void xMove(Direction direction);
	public void yMove(Direction direction);
	public void die();
	public Direction getDirection();
	public void setDirection( Direction direction);
	
}
