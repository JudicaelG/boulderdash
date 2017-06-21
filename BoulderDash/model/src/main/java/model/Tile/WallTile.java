package model.Tile;

import model.Assets;

public class WallTile extends Tile {

public WallTile(int id) {
    super(Assets.wall, id);
}


//METHODS
@Override
public boolean isSolid() { return true; }
}
