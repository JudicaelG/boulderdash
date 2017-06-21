package model;

import java.awt.Graphics;

public abstract class State {
	
	  private static State currentState = null;

	    public static void setState(State state) {
	        currentState = state;
	    }

	    public static State getState() { return currentState; }

	    // METHODS
	    protected Game game;

	    protected BoulderDashModel BoulderDashModel;

	    public State(BoulderDashModel boulderDashModel) {
	        this.BoulderDashModel = boulderDashModel;
	    }
	    public abstract void tick();
	    public abstract void render(Graphics g);
	}
