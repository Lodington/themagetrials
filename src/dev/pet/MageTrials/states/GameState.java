package dev.pet.MageTrials.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.entities.EntityManager;
import dev.pet.MageTrials.entities.creatures.Player;
import dev.pet.MageTrials.worlds.World;

public class GameState extends State {
	
	private World Start;
	public EntityManager entitymanager;
	public String [] worlds = 
		{
		"res/worlds/start.txt",
		"res/worlds/end.txt"
		};
	public static int transition = 0;
	
	public GameState(Handler handler){
		super(handler);
			Start = new World(handler, worlds[transition]);	
		
		handler.setWorld(Start);

		
	}
	
	@Override
	public void tick() {
		Start.tick();
	}

	@Override
	public void render(Graphics g) {
		Start.render(g);
	}

}
