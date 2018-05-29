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
		System.out.println();
	}

	@Override
	public void AdX(int data) {
		this.x += data * this.move_speed;
		if(this.x < -WIDTH/2) this.x = -WIDTH/2;
		if(this.x > WIDTH/2) this.x = WIDTH/2;
	}

	@Override
	public void AdY(int data) {
		this.y += data * this.move_speed;
		if(this.y < -HEIGHT/2) this.y = -HEIGHT/2;
		if(this.y > HEIGHT/2) this.y = HEIGHT/2;
	}

}
