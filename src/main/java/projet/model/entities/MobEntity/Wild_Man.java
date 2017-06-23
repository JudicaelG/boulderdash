package projet.model.entities.MobEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.model.Handler;
import projet.model.Tile;
import projet.view.Animation;
import projet.view.Assets;


public class Wild_Man extends MobEntity{

	public Wild_Man(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		wild_man = new Animation(100, Assets.wild_man);
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		wild_man.tick();
		move();
		}

	public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }
	// Animations
    private Animation wild_man;
    private BufferedImage getCurrentAnimation() { return wild_man.getCurrentFrame(); }
    
    

}
