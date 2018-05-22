package Main;

import Movement.Enemy;
import Movement.Player;

public class Main {

	private int NumberOfEnemy = 1;
	Movement.Enemy enemy1 = new Enemy("ノブオ",5);
	Movement.Enemy enemy2;
	enemy2 = new Enemy("草",15);
	Movement.Player player = new Player();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		enemy1.print_data();
		enemy2.eat(7);
		enemy2.print_data();

	}

	private void CalcEnemyState() {

		for(int i = 0;i < this.NumberOfEnemy;i++) {
			enemy1.Get
		}
	}

}
