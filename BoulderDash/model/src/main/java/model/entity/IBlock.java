package model.entity;

public interface IBlock {
	
	public void cruch (Alive alive);
	public void slide (Direction direction);
	public void fall();
	public Direction getDirection();
	public void setDirection(Direction direction);
}
