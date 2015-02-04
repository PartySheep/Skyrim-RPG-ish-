package com.minymin.game.screen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Screen {

	public void init();
	public void update(GameContainer gc, int i);
	public void render(GameContainer gc, Graphics g);
	
}
