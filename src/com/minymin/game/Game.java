package com.minymin.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.minymin.game.screen.GameScreen;
import com.minymin.game.screen.PauseScreen;
import com.minymin.game.screen.Screen;

public class Game extends BasicGame {

	private Screen screen;
	
	public Game(String title) {
		super(title);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer appgc;
		
			appgc = new AppGameContainer(new Game("Hello World"));
			appgc.setShowFPS(false);
			appgc.setDisplayMode(640, 480, false);// That boolean make fullscreen unescapable!!!!!
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		screen = new GameScreen("map_test.tmx");
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		screen.render(gc, g);
	}

}
