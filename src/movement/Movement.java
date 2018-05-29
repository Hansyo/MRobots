package movement;

import java.util.Random;

import map.Map;

public class Movement extends Map{
	protected int x,y;
	protected static Random rnd = new Random();

	public Movement() {
		this.x = Movement.rnd.nextInt(WIDTH) - WIDTH/2;
		this.y = Movement.rnd.nextInt(HEIGHT) - HEIGHT/2;
	}

	public void PrintX() {
		System.out.println("X :" + this.x);
	}

	public void PrintY() {
		System.out.println("Y :" + this.y);
	}

	public void AdX(int data) {
		this.x += data;
		if(this.x < -WIDTH/2) this.x = -WIDTH/2;
		if(this.x > WIDTH/2) this.x = WIDTH/2;
	}

	public void AdY(int data) {
		this.y += data;
		if(this.y < -HEIGHT/2) this.y = -HEIGHT/2;
		if(this.y > HEIGHT/2) this.y = HEIGHT/2;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public static int getRndNextInt(int range) {
		return Movement.rnd.nextInt(range);
	}

}
