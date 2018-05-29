package main;

import java.util.ArrayList;

import map.Map;
import map.gui.Gui;
import movement.Movement;
import movement.Player;

public class Game extends Map {

	private ArrayList<movement.Enemy> enemy = new ArrayList<movement.Enemy>();
	private movement.Player player = new Player();
	private map.gui.Gui game_board = new Gui();

	public void StartLevel(int level) {
		// speedの1は固定値
		this.player.ResetPlayerState();
		MakeEnemy(level * 2 + level / 5 + 2, 1);
		// this.game_board.SetGameBoard();
		PrintAllEnemy();
		this.player.PrintData();
		CalcEnemyState();
		PrintAllEnemy();
	}

	private void CalcEnemyState() {
		int e_x,e_y,p_x,p_y;
		p_x = this.player.getX();
		p_y = this.player.getY();
		for(int i = 0;i < this.enemy.size();i++) {
			e_x = this.enemy.get(i).getX();
			e_y = this.enemy.get(i).getY();
			if(e_x < p_x) {
				this.enemy.get(i).AdX(1);
			}else if (e_x > p_x) {
				this.enemy.get(i).AdX(-1);
			}
			if(e_y < p_y) {
				this.enemy.get(i).AdY(1);
			}else if (e_y > p_y) {
				this.enemy.get(i).AdY(-1);
			}
		}
	}

	private void PrintAllEnemy() {
		for(int i = 0;i < this.enemy.size();i++) {
			this.enemy.get(i).PrintData(i);
		}
	}

	private void MakeEnemy(int num,int speed) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int state;
		// mapのすべてのマス目を持った、リストの作成
		for(int i = 0;i < super.HEIGHT * super.WIDTH;i++) {
			map.add(new Integer(i));
		}
		// 現在のプレイヤーの位置を抜く
		map.remove(this.player.getY() * super.WIDTH + this.player.getX());
		// 指定された個数分numを抜く
		for(int i = 0;i < num;i++) {
			// 今map内に残っている、ランダムな座標を選択
			state = Movement.getRndNextInt(map.size());
			// mapのState番目の値の座標を調べて抜く
			this.enemy.add(new movement.Enemy(speed,map.get(state) % super.WIDTH, map.get(state) / super.WIDTH));
			// 選択された座標を抜く
			map.remove(state);
		}
	}

}
