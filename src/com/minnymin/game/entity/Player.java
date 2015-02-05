package com.minnymin.game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

public class Player extends Entity {

	private float moveSpeed = 0.25f;

	private int keyDown = Input.KEY_S;
	private int keyUp = Input.KEY_W;
	private int keyLeft = Input.KEY_A;
	private int keyRight = Input.KEY_D;
	private int keyJump = Input.KEY_SPACE;
	//private boolean lastPressed[] = {false, false, false, false, false};

	private int health;
	private int mana;
	private int armour;
	private int skillPoints;
	private int numSteps;
	private int score;

	public Player(int health, int mana, int armour, int numSteps, int scale,
			int score, int speed, int skillPoints) {
		this.health = health;
		this.armour = armour;
		this.numSteps = numSteps;
		this.mana = mana;
		this.score = score;
		this.skillPoints = skillPoints;
	}

	public void addSkillPoints(int i) {
		skillPoints += i;
	}

	public void addHealth(int i) {
		this.health += i;
	}

	public void addArmour(int i) {
		this.armour += i;
	}

	public void numSteps() {
		this.numSteps++;
	}

	public void addScore(int i) {
		score += i;
	}

	public void addMana(int i) {
		mana += i;
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public int getHealth() {
		return health;
	}

	public int getArmour() {
		return armour;
	}

	public int getSteps() {
		return numSteps;
	}

	public int getScore() {
		return score;
	}

	public int getMana() {
		return mana;
	}

	public boolean willCollide(int xPos, int yPos) {
		return true;
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.draw(new Rectangle(xPos, yPos, 10, 10));
	}

	@Override
	public void update(GameContainer gc, int delta) {
		move(gc.getInput(), delta);
	}

	private void move(Input input, int delta) {
		if (input.isKeyDown(keyUp)) {
			yPos+=delta*-moveSpeed;
		}
		
		if (input.isKeyDown(keyDown)) {
			yPos+=delta*moveSpeed;
		}
		
		if (input.isKeyDown(keyLeft)) {
			xPos+=delta*-moveSpeed;
		}
		
		if (input.isKeyDown(keyRight)) {
			xPos+=delta*moveSpeed;
		}
		
		/*if (input.isKeyDown(keyUp) && !lastPressed[0]) {
			velocity.add(new Vector2f(0, -moveSpeed));
			lastPressed[0] = true;
		} else if (lastPressed[0]) {
			velocity.sub(new Vector2f(0, -moveSpeed));
			lastPressed[0] = false;
		}
		if (input.isKeyDown(keyDown) && !lastPressed[1]) {
			velocity.add(new Vector2f(0, moveSpeed));
			lastPressed[1] = true;
		} else if (lastPressed[1]) {
			velocity.sub(new Vector2f(0, moveSpeed));
			lastPressed[1] = false;
		}
		if (input.isKeyDown(keyRight) && !lastPressed[2]) {
			velocity.add(new Vector2f(moveSpeed, 0));
			lastPressed[2] = true;
		} else if (lastPressed[2]) {
			velocity.sub(new Vector2f(moveSpeed, 0));
			lastPressed[2] = false;
		}
		if (input.isKeyDown(keyLeft) && !lastPressed[3]) {
			velocity.add(new Vector2f(-moveSpeed, 0));
			lastPressed[3] = true;
		} else if (lastPressed[3]) {
			velocity.sub(new Vector2f(-moveSpeed, 0));
			lastPressed[3] = false;
		}
		xPos += velocity.getX();
		yPos += velocity.getY();*/
	}

}
