package model;

import java.util.ArrayList;

import model.Tile.Tile;
import model.entity.Alive;
import model.entity.Block;

public interface IBoulderDashModel {

	public ArrayList<Block> getBlock();
	public ArrayList<Alive> getAlive();
	public void addBlock(Block block);
	public void removeBlock(Block block);
	public void addAlive(Alive alive);
	public void removeAlive(Alive alive);
	public void addTile(Tile tile);
	public void removeTile(Tile tile);
}
