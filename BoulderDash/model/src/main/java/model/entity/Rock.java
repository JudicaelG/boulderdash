package model.entity;

import model.BoulderDashModel;
import model.Tile.Tile;


public class Rock extends Block {

	public Rock(BoulderDashModel boulderDashModel, float x, float y) {
        super(boulderDashModel, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }
	public void tick() {

    }
	@Override
	public void cruch(Alive alive) {
		// TODO Auto-generated method stub
		
	}
	
}
