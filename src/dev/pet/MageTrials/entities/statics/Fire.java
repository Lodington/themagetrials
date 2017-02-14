package dev.pet.MageTrials.entities.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.gfx.Animation;
import dev.pet.MageTrials.gfx.Assets;
import dev.pet.MageTrials.items.Item;
import dev.pet.MageTrials.tiles.Tile;

public class Fire extends StaticEntity {
	
	//Animations
	private Animation Flame;

	public Fire(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//Animations

		Flame = new Animation(100, Assets.fire);
		
		bounds.x = 4;
		bounds.y = (int) (height / 2f);
		bounds.width = width ;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {
		Flame.tick();
	}
	
	@Override
	public void die(){
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	private BufferedImage getCurrentAnimationFrame(){
		return Flame.getCurrentFrame();
	}
}
