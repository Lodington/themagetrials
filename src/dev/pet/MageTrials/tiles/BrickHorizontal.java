package dev.pet.MageTrials.tiles;

import dev.pet.MageTrials.gfx.Assets;

public class BrickHorizontal extends Tile {

	public BrickHorizontal(int id) {
		super(Assets.BrickHorizontal, id);
		
		
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}
