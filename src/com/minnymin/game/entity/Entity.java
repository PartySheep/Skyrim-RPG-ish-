package com.minnymin.game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Entity {

	protected float xPos;
	protected float yPos;
	protected Vector2f velocity;
	
	public Entity() {
		xPos = 0;
		yPos = 0;
		velocity = new Vector2f();
	}
	
	public void render(GameContainer gc, Graphics g) {
	}
	
	public void update(GameContainer gc, int i) {
		
	}
	
	
	
}
