package projet.tiles;

import projet.graphics.Assets;

public class RockTile extends Tile {
    // CONSTRUCTOR
    public RockTile(int id) {
        super(Assets.rock, id);
    }


    // METHODS
    @Override
    public boolean isSolid() { return true; }
}
