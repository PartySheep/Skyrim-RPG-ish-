package com.minnymin.game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import com.minymin.game.world.World;

public class Entity {

	protected float xPos;
	protected float yPos;
	protected float prevX;
	protected float prevY;
	protected float width;
	protected float height;
	protected Vector2f velocity;

	protected World world;

	public Entity() {
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
		velocity = new Vector2f();
	}

	public void render(GameContainer gc, Graphics g, int x, int y) {

	}

	public void update(GameContainer gc, int i) {

	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public float getPreviousX() {
		return prevX;
	}
	
	public float getPreviousY() {
		return prevY;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Rectangle getBody() {
		return new Rectangle(xPos, yPos, width, height);
	}

}
