package dev.pet.MageTrials.dialogue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class Intro {
	static Font f = new Font("serif", Font.PLAIN, 72);
	

	public static void start(Graphics g) {
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Greetings, traveler. It seems that you are new to this area.",100,100);
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() < 0 || e.getKeyCode() >= Key.length)
				return;
			keys[e.getKeyCode()] = true;
		}
	}
}
