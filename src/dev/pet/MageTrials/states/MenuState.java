package dev.pet.MageTrials.states;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.sound.sampled.Clip;

import dev.pet.MageTrials.Game;
import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.audio.MusicPlayer;
import dev.pet.MageTrials.gfx.Assets;
import dev.pet.MageTrials.ui.ClickListener;
import dev.pet.MageTrials.ui.UIImageButton;
import dev.pet.MageTrials.ui.UIManager;


public class MenuState extends State  {
	
	private UIManager uiManager;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int btnwidth = gd.getDisplayMode().getWidth()  / 2 - 64;
	int titlewidth = gd.getDisplayMode().getWidth() / 2 - 256;
	
	public MenuState(final Handler gamehandler) {
		super(gamehandler);
		//MenuMusic();
		uiManager = new UIManager(gamehandler);
		gamehandler.getMouseManager().setUIManager(uiManager);
		
		
		uiManager.addObject(new UIImageButton(titlewidth, 100, 512, 128, Assets.titlescreen, new ClickListener() {
			public void onClick() {

			}
		}));
		
		uiManager.addObject(new UIImageButton(btnwidth, 300, 128, 64, Assets.btn_start, new ClickListener() {
			public void onClick() {
				gamehandler.getMouseManager().setUIManager(null);
				Clip song = MusicPlayer.getSongClip();
				MusicPlayer.stop(song);
				State.setState(gamehandler.getGame().gameState);
			}
		}));
		//x, y, width, height
		uiManager.addObject(new UIImageButton(btnwidth, 400, 128, 64, Assets.btn_options, new ClickListener() {
			public void onClick() {
				gamehandler.getMouseManager().setUIManager(null);
				State.setState(new OptionState(new Handler(new Game("test", 100, 100))));
			}	
		}));
		
		uiManager.addObject(new UIImageButton(btnwidth, 500, 128, 64, Assets.btn_exit, new ClickListener() {
			public void onClick() {
				System.exit(0);//Terminate program
			}
		}));
		
	}
	
	@Override
	public void tick() {
		uiManager.tick();	
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
	}

}
