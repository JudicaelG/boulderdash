package projet.model.entities.MobEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.model.Handler;
import projet.model.Tile;
import projet.view.Animation;
import projet.view.Assets;



public class Bat extends MobEntity{

	public Bat(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		bat = new Animation(100, Assets.bat);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		bat.tick();
		move();
	}

	@Override
	public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
	
	// Animations
    private Animation bat;
    private BufferedImage getCurrentAnimation() { return bat.getCurrentFrame(); }
    
    
}
