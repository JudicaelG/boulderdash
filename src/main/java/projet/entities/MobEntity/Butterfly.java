package projet.entities.MobEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.game.Handler;
import tiles.Tile;
import projet.view.Animation;
import projet.view.Assets;

public class Butterfly extends MobEntity{

	public Butterfly(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		// TODO Auto-generated constructor stub
		butterfly = new Animation(100, Assets.butterfly);
	}

	public void tick() {
		// TODO Auto-generated method stub
		butterfly.tick();
		move();
	}

	public void render(Graphics g) {
        g.drawImage(getCurrentAnimation(), (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

    public boolean collectableEntity() { return false; }

    // Animations
    private Animation butterfly;
    private BufferedImage getCurrentAnimation() { return butterfly.getCurrentFrame(); }
    
    
}