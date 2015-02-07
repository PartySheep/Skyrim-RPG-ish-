package com.minymin.game.util;

import org.newdawn.slick.geom.Rectangle;

public class Collision {

	public enum CollisionSide {
		TOP, BOTTOM, LEFT, RIGHT;
	}
	
	private Rectangle obj;
	private CollisionSide side;
	
	public Collision(Rectangle obj, CollisionSide side) {
		this.obj = obj;
		this.side = side;
	}
	
	public Rectangle getObject() {
		return obj;
	}
	
	public CollisionSide getSide() {
		return side;
	}
	
}
