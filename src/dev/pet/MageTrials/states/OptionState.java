package dev.pet.MageTrials.states;


import java.awt.Dimension;

import dev.pet.MageTrials.Game;
import dev.pet.MageTrials.Handler;
import dev.pet.MageTrials.gfx.Assets;
import dev.pet.MageTrials.ui.ClickListener;
import dev.pet.MageTrials.ui.UIImageButton;
import dev.pet.MageTrials.ui.UIManager;

import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class OptionState extends State  {

	private UIManager uiManager;

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int btnwidth = gd.getDisplayMode().getWidth()  / 2 - 64;
	int titlewidth = gd.getDisplayMode().getWidth() / 2 - 256;

	protected State OptionState;
	
	public OptionState(final Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(titlewidth, 100, 512, 128, Assets.Options, new ClickListener() {
			public void onClick() {

			}
		}));
		uiManager.addObject(new UIImageButton(btnwidth, 500, 128, 64, Assets.btn_back, new ClickListener() {
			public void onClick() {
				State.setState(new MenuState(new Handler(new Game("menu", 100, 100))));
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
