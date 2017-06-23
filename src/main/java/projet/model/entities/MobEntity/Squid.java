package projet.model.entities.MobEntity;



import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.model.Handler;
import projet.model.Tile;
import projet.view.Animation;
import projet.view.Assets;


public class Squid extends MobEntity{

	public Squid(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		squid = new Animation(100, Assets.squid);
		bounds.x = 2;
        bounds.y = 2;
        bounds.width = 44;
        bounds.height = 44;
        xMove = 1;
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		squid.tick();
		move();
	}

	
	public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    
	}
	
	
	// Animations
    private Animation squid;
    private BufferedImage getCurrentAnimation() { return squid.getCurrentFrame(); }
    
    

}