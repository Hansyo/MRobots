package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		int level = 1;
		while (true) {
			System.out.println("Now Stage is " + level + "!!");
			game.StartLevel(level);
			while (game.isNotConstPlayertoEnemy() && game.isNotAllEnemyDied()) {
				game.MoveFlow();
			}
			if (!game.isNotConstPlayertoEnemy()) {
				game.GameOverPerform();
				level = 1;
				if(!game.GameContinue()) break;
			} else {
				level++;
			}
		}
		System.exit(0);
	}
}
