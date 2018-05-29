package movement;

public class Enemy extends Movement {
	private int move_speed;

	public Enemy(int speed,int x,int y) {
		this.move_speed = speed;
		super.x = x;
		super.y = y;
	}

	public void PrintData(int i) {
		System.out.print("Enemy[" + i + "]");
		super.PrintX();
		System.out.print("Enemy[" + i + "]");
		super.PrintY();
		System.out.print("Enemy[" + i + "]");
		System.out.println(" : " + this.move_speed);
		System.out.println();
	}

	@Override
	public void AdX(int data) {
		this.x += data * this.move_speed;
		if(this.x < 0) this.x = 0;
		if(this.x > WIDTH) this.x = WIDTH;
	}

	@Override
	public void AdY(int data) {
		this.y += data * this.move_speed;
		if(this.y < 0) this.y = 0;
		if(this.y > HEIGHT) this.y = HEIGHT;
	}

}
