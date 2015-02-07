package com.minymin.game.world;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

import com.minnymin.game.entity.Entity;
import com.minnymin.game.entity.Player;
import com.minymin.game.util.Collision;
import com.minymin.game.util.Collision.CollisionSide;

public class World {

	private String mapLoc;
	private TiledMap map;

	private List<Entity> entities;
	private List<Rectangle> bodies;

	private int backgroundLayer;
	private int foregroundLayer;
	private int collisionLayer;
	private int topLayer;

	public World(String mapName) {
		this.mapLoc = "res/world/" + mapName;
		this.entities = new ArrayList<Entity>();
		this.bodies = new ArrayList<Rectangle>();
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
		for (int i = 0; i < this.map.getObjectCount(0); i++) {
			this.bodies.add(new Rectangle(this.map.getObjectX(0, i), this.map
					.getObjectY(0, i), this.map.getObjectWidth(0, i), this.map
					.getObjectHeight(0, i)));
		}
		// TODO Load entities and world data from file
	}

	public void render(GameContainer gc, Graphics g) {
		this.map.render(0, 0, backgroundLayer);
		this.map.render(0, 0, foregroundLayer);
		for (Entity entity : this.entities) {
			entity.render(gc, g);
		}
		this.map.render(0, 0, topLayer);
	}

	public void update(GameContainer gc, int i) {
		for (Entity entity : this.entities) {
			entity.update(gc, i);
		}
	}

	public Collision doesCollide(Rectangle obj, float speedX, float speedY) {
		for (Rectangle body : bodies) {
			Point topLeft = new Point(obj.getX(), obj.getY());
			Point topRight = new Point(obj.getX() + obj.getWidth(), obj.getY());
			Point bottomLeft = new Point(obj.getX(), obj.getY()
					+ obj.getHeight());
			Point bottomRight = new Point(obj.getX() + obj.getWidth(),
					obj.getY() + obj.getHeight());

			if (body.contains(topLeft)) {
				if (speedX > speedY) {
					return new Collision(body, CollisionSide.RIGHT);
				} else {
					return new Collision(body, CollisionSide.BOTTOM);
				}
			}

			if (body.contains(topRight)) {
				if (speedX > speedY) {
					return new Collision(body, CollisionSide.LEFT);
				} else {
					return new Collision(body, CollisionSide.BOTTOM);
				}
			}

			if (body.contains(bottomLeft)) {
				if (speedX > speedY) {
					return new Collision(body, CollisionSide.RIGHT);
				} else {
					return new Collision(body, CollisionSide.TOP);
				}
			}

			if (body.contains(bottomRight)) {
				if (speedX > speedY) {
					return new Collision(body, CollisionSide.LEFT);
				} else {
					return new Collision(body, CollisionSide.TOP);
				}
			}
		}
		return null;
	}

	public void spawn(Entity en) {
		entities.add(en);
		en.setWorld(this);
	}

}
