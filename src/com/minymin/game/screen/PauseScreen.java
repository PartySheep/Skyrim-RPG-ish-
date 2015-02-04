package com.minymin.game.screen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class PauseScreen implements Screen {

	private GameScreen parent;
	
	public PauseScreen(GameScreen parent) {
		this.parent = parent;
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void update(GameContainer gc, int i) {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		parent.render(gc, g);
		g.drawString("PAUSED", gc.getWidth()/2-10, gc.getHeight()/2-10);
	}

}
