package movement;

public class Enemy extends Movement {
	private int MoveSpeed;

	public Enemy(int Speed) {
		this.MoveSpeed = Speed;
	}

	public void PrintData(int i) {
		System.out.print("Enemy[" + i + "]");
		super.PrintX();
		System.out.print("Enemy[" + i + "]");
		super.PrintY();
		System.out.println();
	}
}
