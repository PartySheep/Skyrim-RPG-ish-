package com.minymin.game;

import com.minymin.*;
public class Player {
private int health; 
private int mana;
private int armour;
private int skillPoints;
private int numSteps; 
private int scale;//Maybe
private boolean isMoving; 
private int speed; 
private int score;

private int xPos;
private int yPos;


public Player(int health, int mana, int armour,  int numSteps, int scale, int score, int speed, int skillPoints){
	this.health = health;
	this.armour = armour;
	this.numSteps = numSteps; 
	this.scale = scale;
	this.speed = speed;
	this.mana = mana;
	this.score = score;
	this.skillPoints = skillPoints;
}


public void addSkillPoints(){
	skillPoints ++;
}
public void addHealth(int i){
	this.health += i;
}
public void addArmour(int i){
	this.armour += i;
}
public void numSteps(){
	this.numSteps++;
}
public void addScore(int i){
	score += i ;
}
public void addMana(int i){
	mana += i;
}
public void setX(int x){
	xPos = x;
}
public void setY(int y){
	yPos = y;
}



public int getSkillPoints(){
	return skillPoints;
}
public int getHealth(){
	return health;
}
public int getArmour(){
	return armour;
}
public int getSteps(){
	return numSteps;
}
public int getScore(){
	return score;
}
public int getMana(){
	return mana;
}
public int getX(){
	return xPos;
}
public int getY(){
	return yPos;
}


public void move(){
	if(UserInput.up.isPressed()   && willCollide((speed * 1)-yPos, 0) == true){
		yPos--;
	}
	if(UserInput.down.isPressed() && willCollide((speed * 1)+yPos, 0) == true){
		yPos++;
	}
	if(UserInput.left.isPressed() && willCollide(0, (speed * 1)-xPos) == true){
		xPos--;
	}
	if(UserInput.right.isPressed()&& willCollide(0, (speed * 1)+xPos) == true){
		xPos++;
	}
}

public void tick(){
	move();
}

public boolean willCollide(int yPos, int xPos){
	return true;
}


}
