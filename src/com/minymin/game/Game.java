package com.minymin.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
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
			appgc.setDisplayMode(1024, 576, false);// That boolean make fullscreen unescapable!!!!!
			appgc.setShowFPS(true);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		screen = new GameScreen("map_test.tmx");
		
		// Set updates per second to 20
		//gc.setMinimumLogicUpdateInterval(20);
		gc.setMaximumLogicUpdateInterval(60);
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input in = gc.getInput();
		if (in.isKeyPressed(Input.KEY_ESCAPE)) {
			if (screen instanceof GameScreen) {
				screen = new PauseScreen((GameScreen)screen);
			} else if (screen instanceof PauseScreen) {
				screen = ((PauseScreen)screen).getParent();
			}
		}
		
		screen.update(gc, i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		screen.render(gc, g);
	}
}
