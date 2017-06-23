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
		bounds.x = 2;
        bounds.y = 2;
        bounds.width = 44;
        bounds.height = 44;
        xMove = 1;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		bat.tick();
		move();
		
		try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
	
	// Animations
    private Animation bat;
    private BufferedImage getCurrentAnimation() { return bat.getCurrentFrame(); }
    
    
}
