package controller;

import model.IBoulderDashModel;

public class BoulderDashController {
	private static int TIME_SLEEP = 30;
	private final IBoulderDashModel boulderDashModel;
	private boolean gameOver = false;
	// private IVewSystem viewSystem;
	
	public BoulderDashController(final IBoulderDashModel boulderDashModel){
		this.boulderDashModel = boulderDashModel;
	}
	
	public void orderPerform(final UserOrder userOrder){
		if (userOrder != null){
			Direction direction;
			
		}
	}
}
