package com.minnymin.game.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import com.minnymin.game.math.FreeBody;
import com.minymin.game.world.World;

public class Entity {

	protected float xPos;
	protected float yPos;
	protected Vector2f velocity;
	
	protected World world;
	
	public Entity() {
		xPos = 0;
		yPos = 0;
		velocity = new Vector2f();
	}
	
	public void render(GameContainer gc, Graphics g) {
	
	}
	
	
	public void update(GameContainer gc, int i) {
		
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public FreeBody getBody() {
		return new FreeBody(0, 0);
	}
	
	
	
}
