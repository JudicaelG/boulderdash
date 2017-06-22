package model.Tile;

public class Tile {

	public static Tile TILES;
	private boolean isSolid;
	private boolean isBreakable;
	// Update 19/06/2017
	public static final int TILEWIDTH = 48;
	public static final int TILEHEIGHT = 48;
	
	
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
