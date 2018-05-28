package main;

import java.util.ArrayList;

import map.Map;
import map.gui.Frame;
import map.gui.Panel;
import movement.Player;

public class Game extends Map {

	ArrayList<movement.Enemy> enemy = new ArrayList<movement.Enemy>();
	movement.Player player = new Player();
	map.gui.Frame game_board = new Frame();
	map.gui.Panel game_panel = new Panel();

	public void StartLevel(int level) {
		game_board.setVisible();
		game_panel.Panel_init();
		MakeEnemy(level * 2 + level / 5 + 2, 1);
		PrintAllEnemy();
		player.PrintData();
		CalcEnemyState();
		PrintAllEnemy();
	}

	private void CalcEnemyState() {
		int e_x,e_y,p_x,p_y;
		p_x = player.getX();
		p_y = player.getY();
		for(int i = 0;i < enemy.size();i++) {
			e_x = enemy.get(i).getX();
			e_y = enemy.get(i).getY();
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

	private void PrintAllEnemy() {
		for(int i = 0;i < enemy.size();i++) {
			enemy.get(i).PrintData(i);
		}
	}

	private void MakeEnemy(int num,int speed) {
		for(int i = 0;i < num;i++) {
			enemy.add(new movement.Enemy(speed));
		}
	}

}
