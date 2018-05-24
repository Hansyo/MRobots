package movement;

public class Enemy extends Movement {
	private int move_speed;

	public Enemy(int speed) {
		this.move_speed = speed;
	}

	public void PrintData(int i) {
		System.out.print("Enemy[" + i + "]");
		super.PrintX();
		System.out.print("Enemy[" + i + "]");
		super.PrintY();
		System.out.println();
	}
}
