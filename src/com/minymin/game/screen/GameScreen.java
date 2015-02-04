package com.minymin.game.screen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.minymin.game.world.World;

public class GameScreen implements Screen {

	private World world;
	
	public GameScreen(String name) {
		this.world = new World(name);
	}
	
	@Override
	public void init() {
		world.load();
	}

	@Override
	public void update(GameContainer gc, int i) {
		world.tick();
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		world.render();
	}

}
