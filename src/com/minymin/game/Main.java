package com.minymin.game;



public class Main {
	private boolean isRunning;
	private int numTicks;


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void start() {
		isRunning = true;
		run();
	}
	public void stop(){
		isRunning = false;
	}
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000/60;
		/*
		 * nsPerTick represents ticks per second. 
		 * 1,000,000,000 nanosecond == 1 second.
		 * Therefore, the program will refresh the calculated number of nanoseconds per 1 tick.
		 */

		//declare variables
		int frames = 0;
		int ticks = 0;
		double counter = 0;
		long lastTimer = System.currentTimeMillis();
		boolean shouldRender = true;//Used to adjust lag
		
		while(isRunning){
			/*
			 * This piece of code is quite a mind bender too first grasp.
			 * However, what is important mathematically for which you must grasp. Is that whenever 
			 */
			long now = System.nanoTime();
			counter +=(now - lastTime)/ nsPerTick;
			lastTime = now;
			while (counter>=1){
				ticks++;
				tick();
				counter-=1;
				shouldRender = true;
			}
			if(frames == 1000){
				shouldRender = false;
			}
			if(shouldRender == true){
				frames++;
				//render();
			}
			if (System.currentTimeMillis()- lastTimer >=1000){
				lastTimer += 1000;
				frames = 0;
				ticks = 0;
			}
		}
	}
	public void tick(){
		numTicks++;
	}
	
	
	public static void main(String[] args) {
		new Main().start();
	}
}
