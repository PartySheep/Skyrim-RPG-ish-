package com.minnymin.game.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;

import com.minnymin.game.math.FreeBody;
import com.minymin.game.util.MathHelper;

public class Player extends Entity {

	private float acceleration = 0.005f;
	private float maxSpeed = 0.3f;
	private float jumpStrength = 0.5f;

	private int keyLeft = Input.KEY_A;
	private int keyRight = Input.KEY_D;
	private int keyJump = Input.KEY_SPACE;

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
		g.fillRect(xPos, yPos, 20, 20);
	}

	@Override
	public void update(GameContainer gc, int delta) {
		move(gc.getInput(), delta);
	}

	private void move(Input input, int delta) {
		if (input.isKeyPressed(keyJump)
				&& velocity.getY() == 0) {
			velocity.add(new Vector2f(0, -jumpStrength));
		}

		if (input.isKeyDown(keyRight)) {
			if (velocity.x < maxSpeed) {
				velocity.add(new Vector2f(acceleration, 0));
			}
		} else {
			if (velocity.x > 0) {
				velocity.sub(new Vector2f(acceleration, 0));
			}
		}

		if (input.isKeyDown(keyLeft)) {
			if (velocity.x > -maxSpeed) {
				velocity.add(new Vector2f(-acceleration, 0));
			}
		} else {
			if (velocity.x < 0) {
				velocity.sub(new Vector2f(-acceleration, 0));
			}
		}

		velocity.add(new Vector2f(0, delta*0.000985f)); // Gravity

		velocity.x = MathHelper.round(velocity.x, 4);
		velocity.y = MathHelper.round(velocity.y, 4);

		if (!world.doesCollide((int) xPos,
				(int) (yPos + delta * velocity.getY()), getBody())) {
			yPos += delta * velocity.getY();
		} else {
			velocity.y = 0;
		}
		if (!world.doesCollide((int) (xPos + delta * velocity.getX()),
				(int) yPos, getBody())) {
			xPos += delta * velocity.getX();
		} else {
			velocity.x = 0;
		}
	}

	@Override
	public FreeBody getBody() {
		return new FreeBody(20, 20);
	}

}
