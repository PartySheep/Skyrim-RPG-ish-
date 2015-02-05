package com.minymin.game.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.minnymin.game.entity.Entity;
import com.minnymin.game.entity.Player;

public class World {

	private String mapLoc;
	private TiledMap map;
	
	private List<Entity> entities;
	
	public World(String mapName) {
		this.mapLoc = "res/world/" + mapName;
		this.entities = new ArrayList<Entity>();
		try {
			this.map = new TiledMap(this.mapLoc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		entities.add(new Player(0, 0, 0, 0, 0, 0, 0, 0));
	}
	
	public void load() {
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
	
}
