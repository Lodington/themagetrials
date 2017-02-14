package dev.pet.MageTrials;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import dev.pet.MageTrials.audio.MusicPlayer;
import dev.pet.MageTrials.utils.ThreadPool;

public class Launcher {

	public static void main(String[] args){
		ThreadPool pool = new ThreadPool(2);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		Game game = new Game("The Mage Trials", width, height);
		
		MusicPlayer player = new MusicPlayer("main_menu");
		pool.runTask(player);
		pool.runTask(game);
		pool.join();
	}
	
}
