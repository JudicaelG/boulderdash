package projet.entities.statics;

import java.awt.Graphics;

import projet.game.Handler;
import projet.view.Assets;
import tiles.Tile;

public class Wall extends StaticEntity{
	public Wall(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
	}
	
	@Override
    public void render(Graphics g) {
        g.drawImage(Assets.wall, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
    }

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
}
