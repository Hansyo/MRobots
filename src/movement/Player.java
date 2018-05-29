package movement;

public class Player extends Movement{

	public Player(){
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
}
