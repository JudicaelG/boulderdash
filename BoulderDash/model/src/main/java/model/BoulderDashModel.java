package model;

import java.util.ArrayList;
import model.Tile.Tile;
import model.entity.Alive;
import model.entity.Block;


public class BoulderDashModel {
	private static Map map;
	private Game game;

	public BoulderDashModel(Game game){
		this.game = game;
	}
	public ArrayList<Block> getBlock(){
		return null;
		
	}
	public ArrayList<Alive> getAlive(){
		return null;
		
	}
	public ArrayList<Tile> getTile(){
		return null;
		
	}
	public void addBlock(Block block){
		
	}
	public void removeBlock(Block block){
		
	}
	public void addAlive(Alive alive){
		
	}
	public void removeAlive(Alive alive){
		
	}
	public void addTile(Tile tile){
		
	}
	public void removeTile(Tile tile){
		
	}
	public KeyManager getKeyManager() { return game.getKeyManager();}
	
	public static Map getMap() {
		// TODO Auto-generated method stub
		return map;
	}
	public static Camera getCamera() {  // static must be place here
		// TODO Auto-generated method stub
		return null;
	}
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setMap(Map map) {
		// TODO Auto-generated method stub
		
	}

	
	}
	
	

