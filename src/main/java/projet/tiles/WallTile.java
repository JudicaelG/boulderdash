package projet.tiles;

import projet.graphics.Assets;

public class WallTile extends Tile {
// CONSTRUCTOR
    public WallTile(int id) {
        super(Assets.wall, id);
    }


// METHODS
    @Override
    public boolean isSolid() { return true; }
}
