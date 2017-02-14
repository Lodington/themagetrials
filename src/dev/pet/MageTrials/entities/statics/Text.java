package dev.pet.MageTrials.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.tiles.Tile;

public class Text extends StaticEntity {

	public Text(Handler handler, float  x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		
		bounds.x = 4;
		bounds.y = (int) (height / 2f);
		bounds.width = width ;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		
	}

	
	@Override
	public void die(){

	}

	@Override
	public void render(Graphics g) {
		g.drawString("Welcome to the Mage Trials", (int) x, (int) y);
	}

}
