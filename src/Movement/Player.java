package Movement;

public class Player extends Movement{

	public Player(){
		super.x = super.y = 0;
	}

	public void PrintData() {
		System.out.print("Player ");
		super.PrintX();
		System.out.print("Player ");
		super.PrintY();
		System.out.println();
	}
}
