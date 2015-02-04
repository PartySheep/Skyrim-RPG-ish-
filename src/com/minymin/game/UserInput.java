package com.minymin.game;

import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class UserInput implements KeyListener {
	
	private int numTimesPressed = 0;
	private boolean pressed = false;

	public static UserInput up = new UserInput();
	public static UserInput down = new UserInput();
	public static UserInput left = new UserInput();
	public static UserInput right = new UserInput();
	public static UserInput esc = new UserInput();
	public static UserInput control = new UserInput();
	public void toggle(boolean isPressed){
		pressed = isPressed;
		if(pressed){
			numTimesPressed++;
		}
	}
	public boolean isPressed(){
		return pressed;
	}
	
		
	
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);

	}

	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);

	}
	public void keyTyped(KeyEvent e) {
		toggleKey(e.getKeyCode(),true);
	}

	public void toggleKey(int keyCode, boolean isPressed){
		if(keyCode == KeyEvent.VK_W ||keyCode == KeyEvent.VK_UP){
			up.toggle(isPressed);}
		if(keyCode == KeyEvent.VK_S||keyCode == KeyEvent.VK_DOWN){
			down.toggle(isPressed);}
		if(keyCode == KeyEvent.VK_A||keyCode == KeyEvent.VK_LEFT){
			left.toggle(isPressed);}
		if(keyCode == KeyEvent.VK_D||keyCode == KeyEvent.VK_RIGHT ){
			right.toggle(isPressed);}
		if(keyCode == KeyEvent.VK_ESCAPE){
			esc.toggle(isPressed);
			if(keyCode == KeyEvent.VK_CONTROL){
				control.toggle(isPressed);
			}

		}

	}
}
	



