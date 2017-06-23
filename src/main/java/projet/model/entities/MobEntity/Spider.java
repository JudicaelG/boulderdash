package projet.model.entities.MobEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.model.Handler;
import projet.model.Tile;
import projet.view.Animation;
import projet.view.Assets;

public class Spider extends MobEntity{
	
	public Spider(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		spider = new Animation(100, Assets.spider);
	}

	
    public void tick() {
        spider.tick();
        move();
    }

    
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    
    public boolean collectableEntity() { return false; }

    // Animations
    private Animation spider;
    private BufferedImage getCurrentAnimation() { return spider.getCurrentFrame(); }
    
    
}

