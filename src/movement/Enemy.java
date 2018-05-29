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

	/*
	 * old_x[y] と this.x[y]の間にplayerがいたら、this.x[y] = player.x[y]
	 * みたいな処理を書けば、OK!!
	 * これで敵の動きはOK
	 * あとは衝突判定
	 */
	@Override
	public void AddX(int data) {
		this.x += data * this.move_speed;
		if(this.x < 0) this.x = 0;
		if(this.x > WIDTH) this.x = WIDTH;
	}

	@Override
	public void AddY(int data) {
		this.y += data * this.move_speed;
		if(this.y < 0) this.y = 0;
		if(this.y > HEIGHT) this.y = HEIGHT;
	}

	public int getMove_speed() {
		return move_speed;
	}


}
