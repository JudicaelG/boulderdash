package model.Tile;

public class Tile {

	public static Tile TILES;
	private boolean isSolid;
	private boolean isBreakable;
	
	
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public boolean isBreakable() {
		return isBreakable;
	}
	public void setBreakable(boolean isBreakable) {
		this.isBreakable = isBreakable;
	}
	
	
}
