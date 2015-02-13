package com.minymin.game.screen;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.minnymin.game.entity.Player;
import com.minymin.game.world.World;

public class GameScreen implements Screen {

	private World world;
	private Player player;

	private int cameraX;
	private int cameraY;

	public GameScreen(String name) {
		this.world = new World(name);
		this.player = new Player(0, 0, 0, 0, 0, 0, 0, 0);
		this.world.spawn(player);
	}

	@Override
	public void init() {
	}

	@Override
	public void update(GameContainer gc, int i) {
		world.update(gc, i);
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		if (player.getX() != player.getPreviousX()) {
			int oneThirdX = cameraX + gc.getWidth() - (2*gc.getWidth() / 3);
			int twoThirdX = cameraX + gc.getWidth() - (gc.getWidth() / 3);
			if (player.getX() > twoThirdX) {
				cameraX += player.getX() - twoThirdX;
				if (cameraX > world.getWidth() - gc.getWidth()) {
					cameraX = world.getWidth() - gc.getWidth();
				}
			} else if (player.getX() < oneThirdX) {
				cameraX -= oneThirdX - player.getX();
				if (cameraX < 0) {
					cameraX = 0;
				}
			}
		}
		if (player.getY() != player.getPreviousY()) {
			int oneThirdY = cameraY + gc.getHeight() - (2*gc.getHeight() / 3);
			int twoThirdY = cameraY + gc.getHeight() - (gc.getHeight() / 3);
			if (player.getY() > twoThirdY) {
				cameraY += player.getY() - twoThirdY;
				if (cameraY > world.getHeight()-gc.getHeight()) {
					cameraY = world.getHeight() - gc.getHeight();
				}
			} else if (player.getY() < oneThirdY) {
				cameraY-= oneThirdY-player.getY();
				if (cameraY < 0) {
					cameraY = 0;
				}
			}
		}

		System.out.println(cameraX + " - " + cameraY);
		
		world.render(gc, g, cameraX, cameraY);
	}

}
