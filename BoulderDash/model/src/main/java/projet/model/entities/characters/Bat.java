package projet.model.entities.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Assets;
import model.BoulderDashModel;

public class Bat extends Mob implements Runnable{
	
	private Animation bat;
	
	private final int PAUSE = 15;
	private int dxBat;
	
	public Bat(BoulderDashModel boulderDashModel, float x, float y, int width, int height) {
		super(boulderDashModel, x, y, width, height);
		// TODO Auto-generated constructor stub
		
		//ANIMATIONS
		bat = new Animation(500, Assets.bat);
	}
	private BufferedImage getCurrentAnimation() { return bat.getCurrentFrame(); }

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		bat.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getCurrentAnimation(), width, height, null);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
