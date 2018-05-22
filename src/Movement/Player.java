package Movement;

public class Player {
	private int x,y;
	public Player() {
		this.x = 0;
		this.y = 0;
	}

	public int CompStateX(int x) {
		if(this.x == x) return 0;
		else if(this.x < x) return -1;
		else return 1;
	}

	public int GetStateY() {
		return this.y;
	}

	public int GetStateX() {
		return this.x;
	}
}
