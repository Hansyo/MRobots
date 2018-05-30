package main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import map.Map;
import map.gui.Gui;
import movement.Movement;
import movement.Player;

public class Game extends Map {

	private ArrayList<movement.Enemy> enemy = new ArrayList<movement.Enemy>();
	private ArrayList<JLabel> label = new ArrayList<JLabel>();
	private movement.Player player = new Player();
	private map.gui.Gui game_board = new Gui();

	public Game() {
		this.game_board.setGameBoard();
		relateLabelAndPanel();
	}

	private void relateLabelAndPanel() {
		for (int i = 0; i < game_board.getGridSize(); i++) {
			this.label.add(new JLabel(""));
			this.label.get(i).setBackground(Color.CYAN);
			this.label.get(i).setForeground(Color.BLACK);
			this.label.get(i).setHorizontalAlignment(JLabel.CENTER);
			this.label.get(i).setOpaque(true);
			game_board.addLabeltoPanel(label.get(i));
		}
	}

	public void StartLevel(int level) {
		// speedの1は固定値
		this.player.ResetPlayerState();
		MakeEnemy(level * 2 + level / 5 + 2, 1);
		MakeEnemy(level / 3, 2);
		PrintAllEnemy();
		this.player.PrintData();
		this.game_board.setVisible(true);
		PrintAllElements();
	}

	public void MoveFlow() {
		CalcPlayerState();
		CalcEnemyState();
		PrintAllElements();
	}

	private void CalcPlayerState() {
		int i;

		try {
			do {
				i = System.in.read();
				switch ((char) i) {
				case '0':
					i = 0;
					System.out.println("Teleport!!");
					TeleportPlayer();
					break;
				case '1':
					i = player.CalcPlayerState(-1, +1);
					break;
				case '2':
					i = player.CalcPlayerState(0, +1);
					break;
				case '3':
					i = player.CalcPlayerState(+1, +1);
					break;
				case '4':
					i = player.CalcPlayerState(-1, 0);
					break;
				case '5':
					i = 0;
					break;
				case '6':
					i = player.CalcPlayerState(+1, 0);
					break;
				case '7':
					i = player.CalcPlayerState(-1, -1);
					break;
				case '8':
					i = player.CalcPlayerState(0, -1);
					break;
				case '9':
					i = player.CalcPlayerState(+1, -1);
					break;
				default:
					i = 1;
				}
			} while (i != 0);
		} catch (IOException e) {
			System.out.println("入力エラーです");
		}
	}

	private void CalcEnemyState() {
		int e_x, e_y, p_x, p_y;
		p_x = this.player.getX();
		p_y = this.player.getY();
		for (int i = 0; i < this.enemy.size(); i++) {
			for (int j = 0; j < this.enemy.get(i).getMove_speed(); j++) {
				e_x = this.enemy.get(i).getX();
				e_y = this.enemy.get(i).getY();
				this.label.get(e_y * this.game_board.getPanelWIDTH() + e_x).setText("");
				if (e_x < p_x) {
					this.enemy.get(i).AddX(1);
				} else if (e_x > p_x) {
					this.enemy.get(i).AddX(-1);
				}
				System.out.println("i : " + i);
				if (e_y < p_y) {
					this.enemy.get(i).AddY(1);
				} else if (e_y > p_y) {
					this.enemy.get(i).AddY(-1);
				}
			}
		}
	}

	public void PrintAllElements() {
		PrintPlayer();
		PrintAllEnemy();
	}

	private void PrintPlayer() {
		this.label.get(this.player.getOld_y() * super.WIDTH + this.player.getOld_x()).setText("");
		this.label.get(this.player.getY() * super.WIDTH + this.player.getX()).setText("@");
		this.player.PrintData();
	}

	private void PrintAllEnemy() {
		int e_state;
		for (int i = 0; i < this.enemy.size(); i++) {
			this.enemy.get(i).PrintData(i);
			e_state = this.enemy.get(i).getY() * this.game_board.getPanelWIDTH();
			e_state += this.enemy.get(i).getX();
			System.out.println("[" + i + "]e_state: " + e_state);
			System.out.println(this.label.size() + "\n");
			switch (this.enemy.get(i).getMove_speed()) {
			case 1:
				this.label.get(e_state).setText("①");
				break;
			case 2:
				this.label.get(e_state).setText("②");
				break;
			default:
				this.label.get(e_state).setText("*");
				break;
			}
		}
	}

	private void MakeEnemy(int num, int speed) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int state;
		// mapのすべてのマス目を持った、リストの作成
		for (int i = 0; i < super.HEIGHT * super.WIDTH; i++) {
			map.add(new Integer(i));
		}

		// 現在のプレイヤーの位置を抜く
		map.remove(this.player.getY() * super.WIDTH + this.player.getX());

		for (int i = 0; i < num; i++) {
			// 今map内に残っている、ランダムな座標を選択
			state = Movement.getRndNextInt(map.size());

			// 選択された座標をEnemyの初期位置とする
			this.enemy.add(new movement.Enemy(speed, map.get(state) % super.WIDTH, map.get(state) / super.WIDTH));

			// mapのState番目の値の座標を調べて抜く
			map.remove(state);
		}
	}

	private void TeleportPlayer() {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int state;

		player.setOld_x(player.getX());
		player.setOld_y(player.getY());

		for (int i = 0; i < super.HEIGHT * super.WIDTH; i++) {
			map.add(new Integer(i));
		}
		map.remove(player.getY() * super.WIDTH + player.getX());
		for (int i = 0; i < enemy.size();i++) {
			map.remove(enemy.get(i).getY() * super.WIDTH+ enemy.get(i).getX());
		}

		state = map.get(Movement.getRndNextInt(map.size()));
		System.out.println("staet.y : " + state / super.WIDTH + "\nstate.x : " + state % super.WIDTH);
		player.setState(state % super.WIDTH, state / super.WIDTH);

	}
}
