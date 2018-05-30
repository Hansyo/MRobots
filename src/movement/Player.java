package movement;

public class Player extends Movement {

	private int old_x, old_y;

	public Player() {
		ResetPlayerState();
	}

	public void PrintData() {
		System.out.print("Player ");
		super.PrintX();
		System.out.print("Player ");
		super.PrintY();
		System.out.println();
	}

	public void ResetPlayerState() {
		super.x = super.WIDTH / 2;
		super.y = super.HEIGHT / 2;
	}

	public boolean CalcPlayerState(int x, int y) {
		int c_x, c_y;
		// xとyが範囲内にあるかどうかの確認
		if ((-1 <= x && x <= 1) && (-1 <= y && y <= 1)) {
			c_x = super.getX() + x;
			c_y = super.getY() + y;
			// 移動した先が範囲内にあるかの確認
			if ((0 <= c_x && c_x < super.WIDTH) && (0 <= c_y && c_y < super.HEIGHT)) {
				this.old_x = super.getX();
				this.old_y = super.getY();
				super.AddX(x);
				super.AddY(y);
				return true;
			}
		}
		return false;
	}

	public int getOld_x() {
		return old_x;
	}

	public int getOld_y() {
		return old_y;
	}

	public void setOld_x(int old_x) {
		this.old_x = old_x;
	}

	public void setOld_y(int old_y) {
		this.old_y = old_y;
	}

	public void setState(int x, int y) {
		super.x = x;
		super.y = y;
	}
}
