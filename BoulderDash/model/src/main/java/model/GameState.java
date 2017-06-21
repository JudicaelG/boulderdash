package model;

import java.awt.Graphics;

public class GameState extends State {

	   private Map map;


	    // CONSTRUCTOR
	    public GameState(BoulderDashModel boulderDashModel) {
	        super(boulderDashModel);
	        map = new Map(boulderDashModel, "res/Maps/Map1.txt");
	        BoulderDashModel.setMap(map);
	        model.BoulderDashModel.getCamera().move(0, 0);
	    }


	    // METHODS
	    
	    public void tick() {
	        Map.tick();
	        //BoulderDashModel.getCamera().move(1, 1);
	    }

	    @Override
	    public void render(Graphics g) {
	        Map.render(g);
	    }
	}
