package com.minymin.game.world;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class World {

	private String mapLoc;
	private TiledMap map;
	
	public World(String mapName) {
		this.mapLoc = "res/world/" + mapName;
		try {
			this.map = new TiledMap(this.mapLoc);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		// TODO Load entities and world data from file
	}
	
	public void render() {
		this.map.render(0, 0);
	}
	
	public void tick() {
		// TODO Tick entities/time/etc.
	}
	
}
