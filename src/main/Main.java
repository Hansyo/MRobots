package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.StartLevel(3);
		while(true) {
			game.MoveFlow();
		}
	}

}
