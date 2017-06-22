package model;

import view.Assets;

public class RockTile extends Tile {
    // CONSTRUCTOR
    public RockTile(int id) {
        super(Assets.rock[0], id);
    }


    // METHODS
    @Override
    public boolean isSolid() { return true; }
}
