package movement;

public class Enemy extends Movement {
	private int move_speed;

	public Enemy(int speed, int x, int y) {
		this.move_speed = speed;
		this.x = x;
		this.y = y;
	}

	public int getMove_speed() {
		return move_speed;
	}

	public void setMove_speed(int move_speed) {
		this.move_speed = move_speed;
	}

}
