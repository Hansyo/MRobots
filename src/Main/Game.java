package Main;

import java.util.ArrayList;

import Map.Map;
import Movement.Player;

public class Game extends Map {

	static ArrayList<Movement.Enemy> enemy = new ArrayList<Movement.Enemy>();
	static Movement.Player player = new Player();

	public void StartLevel(int Level) {

	}

	private void CalcEnemyState() {
		int e_x,e_y,p_x,p_y;
		p_x = player.GetX();
		p_y = player.GetY();
		for(int i = 0;i < enemy.size();i++) {
			e_x = enemy.get(i).GetX();
			e_y = enemy.get(i).GetY();
			if(e_x < p_x) {
				enemy.get(i).AdX(1);
			}else if (e_x > p_x) {
				enemy.get(i).AdX(-1);
			}
			if(e_y < p_y) {
				enemy.get(i).AdY(1);
			}else if (e_y > p_y) {
				enemy.get(i).AdY(-1);
			}
		}
	}

	private static void PrintAllEnemy() {
		for(int i = 0;i < enemy.size();i++) {
			enemy.get(i).PrintData(i);
		}
	}

	private void MakeEnemy(int Num,int Speed) {
		for(int i = 0;i < Num;i++) {
			enemy.add(new Movement.Enemy(Speed));
		}
	}

}
