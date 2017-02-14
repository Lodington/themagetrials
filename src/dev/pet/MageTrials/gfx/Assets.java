package dev.pet.MageTrials.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int x = 32, y = x;
	private static final int width = 32, height = width;
	
	public static BufferedImage dirt, grass, WoodFloor, BrickHorizontal, tree, rock, wood, Black, DarkBrick;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] btn_start, btn_options, btn_exit, btn_back;
	public static BufferedImage[] titlescreen, Options;
	public static BufferedImage[] fire;

	public static void init(){
		
		SpriteSheet Main = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet girl = new SpriteSheet(ImageLoader.loadImage("/textures/girl.png"));
		SpriteSheet ui = new SpriteSheet(ImageLoader.loadImage("/textures/ui.png"));
		SpriteSheet Fire = new SpriteSheet(ImageLoader.loadImage("/textures/flame.png"));
		
		btn_start = new BufferedImage[2];
		btn_options = new BufferedImage[2];
		btn_exit = new BufferedImage[2];
		btn_back = new BufferedImage[2];
		titlescreen = new BufferedImage[2];
		Options = new BufferedImage[2];
		
		btn_start[0] = ui.crop(0, 0, width * 2, height);
		btn_start[1] = ui.crop(x * 2, 0, width * 2, height);
		
		btn_options[0] = ui.crop(0, y, width * 2, height);
		btn_options[1] = ui.crop(x *2, y, width * 2, height);
		
		btn_exit[0] = ui.crop(0, y * 2, width * 2, height);
		btn_exit[1] = ui.crop(x * 2, y * 2, width * 2, height);
		
		btn_back[0] = ui.crop(0, y * 3, width * 2, height);
		btn_back[1] = ui.crop(x, y * 3, width * 2, height);
		
		titlescreen[0] = ui.crop(0, y * 4, width * 8, height * 2);
		titlescreen[1] = ui.crop(0, y * 4, width * 8, height * 2);
		Options[0] = ui.crop(0, y * 6, width * 8, height * 2);
		Options[1] = ui.crop(0, y * 6, width * 8, height * 2);
		
		fire = new BufferedImage[5];
		
		fire[0] = Fire.crop(0, 0, width * 2, height * 3);
		fire[1] = Fire.crop(x * 2, 0, width * 2, height * 3);
		fire[2] = Fire.crop(x * 4, 0, width * 2, height * 3);
		fire[3] = Fire.crop(x * 6, 0, width * 2, height * 3);
		fire[4] = Fire.crop(0, y * 3, width * 2, height * 3);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		/*
		 * for finding the sprite use this:
		 * 	Sheetname.crop(x, y, width, height);
		 */
		player_down[0] = girl.crop(0, 0, width, height * 2);
		player_down[1] = girl.crop(x, 0, width, height * 2);
		player_down[2] = girl.crop(x * 2, 0, width, height * 2);
		player_down[3] = girl.crop(x * 3, 0, width, height * 2);
		
		player_up[0] = girl.crop(0, y * 6, width, height * 2);
		player_up[1] = girl.crop(x, y * 6, width, height * 2);
		player_up[2] = girl.crop(x * 2, y * 6, width, height * 2);
		player_up[3] = girl.crop(x * 3, y * 6, width, height * 2);
		
		player_right[0] = girl.crop(0, y * 4, width, height * 2);
		player_right[1] = girl.crop(x, y * 4, width, height * 2);
		player_right[2] = girl.crop(x * 2, y * 4, width, height * 2);
		player_right[3] = girl.crop(x * 3, y * 4, width, height * 2);
		
		player_left[0] = girl.crop(0, y * 2, width, height * 2);
		player_left[1] = girl.crop(x, y * 2, width, height * 2);
		player_left[2] = girl.crop(x * 2, y * 2, width, height * 2);
		player_left[3] = girl.crop(x* 3, y * 2, width, height * 2);
		
		zombie_down = new BufferedImage[2];
		zombie_up = new BufferedImage[2];
		zombie_left = new BufferedImage[2];
		zombie_right = new BufferedImage[2];
		
		/*
		zombie_down[0] = sheet.crop(width * 4, height * 2, width, height);
		zombie_down[1] = sheet.crop(width * 5, height * 2, width, height);
		zombie_up[0] = sheet.crop(width * 6, height * 2, width, height);
		zombie_up[1] = sheet.crop(width * 7, height * 2, width, height);
		zombie_right[0] = sheet.crop(width * 4, height * 3, width, height);
		zombie_right[1] = sheet.crop(width * 5, height * 3, width, height);
		zombie_left[0] = sheet.crop(width * 6, height * 3, width, height);
		zombie_left[1] = sheet.crop(width * 7, height * 3, width, height);
		
		*/
		
		DarkBrick = Main.crop(x * 5, 0, width, height);
		dirt = Main.crop(x, 0, width, height);
		grass = Main.crop(x * 2, 0, width, height);
		BrickHorizontal = Main.crop(x * 3, 0, width, height);
		tree = Main.crop(0, 0, width, height * 2);
		WoodFloor = Main.crop(0, y * 2, width, height);
		rock = Main.crop(x, y, width, height);
		Black = Main.crop(x * 4, 0 ,width, height);
	}
	
}
