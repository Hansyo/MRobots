package movement;

public class Enemy extends Movement {
	private int move_speed;

	public Enemy(int speed,int x,int y) {
		this.move_speed = speed;
		this.x = x;
		this.y = y;
	}

	public void PrintData(int i) {
		System.out.print("Enemy[" + i + "]");
		super.PrintX();
		System.out.print("Enemy[" + i + "]");
		super.PrintY();
		System.out.print("Enemy[" + i + "]");
		System.out.println("S: " + this.move_speed);
		System.out.println();
	}

	public int getMove_speed() {
		return move_speed;
	}


}
