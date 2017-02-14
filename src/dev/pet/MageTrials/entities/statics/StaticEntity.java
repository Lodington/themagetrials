package dev.pet.MageTrials.entities.statics;

import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}
