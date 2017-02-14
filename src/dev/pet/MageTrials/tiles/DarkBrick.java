package dev.pet.MageTrials.tiles;

import dev.pet.MageTrials.gfx.Assets;

public class DarkBrick extends Tile {

	public DarkBrick(int id) {
		super(Assets.DarkBrick, id);
		
		
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}
