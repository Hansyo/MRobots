package Movement;

import java.util.Random;

import Map.Map;

public class Movement extends Map{
	protected int x,y;
	private Random rnd = new Random();

	public Movement() {
		this.x = rnd.nextInt(width) - width/2;
		this.y = rnd.nextInt(height) - height/2;
	}

	public void PrintX() {
		System.out.println("X :" + this.x);
	}

	public void PrintY() {
		System.out.println("Y :" + this.y);
	}

	public void AdX(int data) {
		this.x += data;
		if(this.x < -width/2) this.x = -width/2;
		if(this.x > width/2) this.x = width/2;
	}

	public void AdY(int data) {
		this.y += data;
		if(this.y < -height/2) this.y = -height/2;
		if(this.y > height/2) this.y = height/2;
	}

	public int GetX() {
		return this.x;
	}

	public int GetY() {
		return this.y;
	}
}
