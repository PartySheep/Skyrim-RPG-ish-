package com.minymin.game.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.minnymin.game.entity.Entity;
import com.minnymin.game.entity.Player;
import com.minnymin.game.math.FreeBody;

public class World {

	private String mapLoc;
	private TiledMap map;

	private List<Entity> entities;

	private int backgroundLayer;
	private int foregroundLayer;
	private int collisionLayer;
	private int topLayer;

	public World(String mapName) {
		this.mapLoc = "res/world/" + mapName;
		this.entities = new ArrayList<Entity>();
		try {
			load();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		spawn(new Player(0, 0, 0, 0, 0, 0, 0, 0));
	}

	public void load() throws SlickException {
		this.map = new TiledMap(this.mapLoc);
		backgroundLayer = this.map.getLayerIndex("background");
		foregroundLayer = this.map.getLayerIndex("foreground");
		topLayer = this.map.getLayerIndex("top");
		collisionLayer = 0;
		if (backgroundLayer == -1 || foregroundLayer == -1
				|| collisionLayer == -1 || topLayer == -1) {
			throw new SlickException(
					"Could not load map: layer format unrecognized");
		}
		// TODO Load entities and world data from file
	}

	public void render(GameContainer gc, Graphics g) {
		this.map.render(0, 0);
		for (Entity entity : this.entities) {
			entity.render(gc, g);
		}
	}

	public void update(GameContainer gc, int i) {
		for (Entity entity : this.entities) {
			entity.update(gc, i);
		}
	}

	public boolean doesCollide(int x, int y) {
		int objX, objY;
		for (int i = 0; i < map.getObjectCount(0); i++) {
			objX = map.getObjectX(0, i);
			objY = map.getObjectY(0, i);
			if (x >= objX && x <= map.getObjectWidth(0, i) + objX) {
				if (y >= objY && y <= map.getObjectHeight(0, i) + objY) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean doesCollide(int x, int y, FreeBody body) {
		int objX, objY, objWidth, objHeight;
		for (int i = 0; i < map.getObjectCount(0); i++) {
			objX = map.getObjectX(0, i);
			objY = map.getObjectY(0, i);
			objWidth = map.getObjectWidth(0, i);
			objHeight = map.getObjectHeight(0, i);
			if (x >= objX && x <= objWidth + objX) {
				if (y >= objY && y <= objHeight + objY) {
					return true;
				}
			}
			if (x + body.getWidth() >= objX
					&& x + body.getWidth() <= objWidth + objX) {
				if (y >= objY && y <= objHeight + objY) {
					return true;
				}
			}
			if (x >= objX && x <= objWidth + objX) {
				if (y + body.getHeight() >= objY
						&& y + body.getHeight() <= objHeight + objY) {
					return true;
				}
			}
			if (x + body.getWidth() >= objX
					&& x + body.getWidth() <= objWidth + objX) {
				if (y + body.getHeight() >= objY
						&& y + body.getHeight() <= objHeight + objY) {
					return true;
				}
			}
		}
		if (x > map.getWidth()*map.getTileWidth() || x < 0) {
			return true;
		}
		if (y > map.getHeight()*map.getTileHeight() || y < 0) {
			return true;
		}
		return false;
	}

	public void spawn(Entity en) {
		entities.add(en);
		en.setWorld(this);
	}

}
