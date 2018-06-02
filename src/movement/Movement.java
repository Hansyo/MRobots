package movement;

import java.util.Random;

import map.Map;

public class Movement extends Map {
	protected int x, y;
	private static Random rnd = new Random();

	public Movement() {
		this.x = Movement.rnd.nextInt(WIDTH);
		this.y = Movement.rnd.nextInt(HEIGHT);
	}

	public void AddX(int data) {
		this.x += data;
		if (this.x < 0)
			this.x = 0;
		if (this.x > WIDTH)
			this.x = WIDTH;
	}

	public void AddY(int data) {
		this.y += data;
		if (this.y < 0)
			this.y = 0;
		if (this.y > HEIGHT)
			this.y = HEIGHT;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getState() {
		return this.y * super.WIDTH + this.x;
	}

	public static int getRndNextInt(int range) {
		return Movement.rnd.nextInt(range);
	}

}
