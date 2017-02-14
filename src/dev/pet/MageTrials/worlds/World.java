package dev.pet.MageTrials.worlds;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.entities.EntityManager;
import dev.pet.MageTrials.entities.creatures.Player;
import dev.pet.MageTrials.entities.statics.Fire;
import dev.pet.MageTrials.entities.statics.Rock;
import dev.pet.MageTrials.entities.statics.Text;
import dev.pet.MageTrials.entities.statics.Tree;
import dev.pet.MageTrials.gfx.Assets;
import dev.pet.MageTrials.items.ItemManager;
import dev.pet.MageTrials.tiles.Tile;
import dev.pet.MageTrials.ui.ClickListener;
import dev.pet.MageTrials.ui.UIImageButton;
import dev.pet.MageTrials.ui.UIManager;
import dev.pet.MageTrials.dialogue.*;
import dev.pet.MageTrials.utils.Utils;

public class World {

	int wrapperwidth = 300;
	int wrapperheight = 100;
	//screen size && info bar
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int x = gd.getDisplayMode().getWidth() - wrapperwidth;
	
	//x, y , width , height
	
	int wrapperspacer = 50;
	int push = 10;
	int[] healthbar = {x + wrapperspacer, 10, 200, 25};
	int spacer = 30;
	int[] manabar = {healthbar[0], healthbar[1] + spacer, healthbar[2], healthbar[3]};
	int[] xpbar = {manabar[0], manabar[1] + spacer, manabar[2] -70 , manabar[3]};
	
	//x,y
	int[] HealthLabel = {healthbar[0] - wrapperspacer + push, 30};
	int[] ManaLabel = {manabar[0] - wrapperspacer + push, 55};
	int[] xpLabel = {xpbar[0] - wrapperspacer + push, 85};
	String[] Label = {"HP","Mana","XP","Money"}; 
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		// Temporary entity code!
		//entityManager.addEntity(new Fire(handler, 960, 300));
		//entityManager.addEntity(new Fire(handler, 1150, 300));
		//entityManager.addEntity(new Tree(handler, 1350, 400));
		//entityManager.addEntity(new Tree(handler, 750, 400));

		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
	}
	
	
	public void paintInfoBox(Graphics g) {
		//draw here
		Intro.start(g);
		
		
	/*	g.fillRect(x, 0, wrapperwidth, wrapperheight);
		//health bar
		g.setColor(Color.red);
		g.fillRect(healthbar[0],  healthbar[1], healthbar[2], healthbar[3]);
		g.setColor(Color.white);
		g.drawString(Label[0], HealthLabel[0], HealthLabel[1]); //Draws hp
		//mana bar
		g.setColor(Color.BLUE);
		g.fillRect(manabar[0], manabar[1], manabar[2], manabar[3]);
		g.setColor(Color.WHITE);
		g.drawString(Label[1], ManaLabel[0], ManaLabel[1]);
		//xp
		g.setColor(Color.green);
		g.fillRect(xpbar[0], xpbar[1], xpbar[2], xpbar[3]);
		g.setColor(Color.white);
		g.drawString(Label[2], xpLabel[0], xpLabel[1]);*/


		
	}
	
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		paintInfoBox(g);
		
		// Items
		itemManager.render(g);
		//Entities
		//entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}








