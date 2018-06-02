package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

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
	private int key;

	public Game() {
		this.game_board.setGameBoard();
		relateLabelAndPanel();
		// super.addKeyListener(this);
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
		this.enemy.clear();
		LabelClear();
		MakeEnemy(level * 2 + level / 5 + 2, 1);
		MakeEnemy(level / 3, 2);
		PrintAllEnemy();
		this.game_board.setVisible(true);
		PrintAllElements();
	}

	private void LabelClear() {
		for (int i = 0; i < label.size(); i++) {
			label.get(i).setText("");
		}
	}

	public void MoveFlow() {
		CalcPlayerState();
		CalcEnemyState();
		constEnemytoEnemy();
		PrintAllElements();
	}

	private void CalcPlayerState() {
		boolean state;

		do {
			// System.out.println("Start GetKey!!");
			this.key = game_board.getKey();
			// System.out.println("GetKey!!" + this.key);
			state = false;
			switch (this.key) {
				case KeyEvent.VK_0:
				case KeyEvent.VK_NUMPAD0:
				case KeyEvent.VK_SPACE:
					state = true;
					// System.out.println("Teleport!!");
					TeleportPlayer();
					break;
				case KeyEvent.VK_1:
				case KeyEvent.VK_NUMPAD1:
				case KeyEvent.VK_Z:
					state = player.CalcPlayerState(-1, +1);
					break;
				case KeyEvent.VK_2:
				case KeyEvent.VK_NUMPAD2:
				case KeyEvent.VK_X:
					state = player.CalcPlayerState(0, +1);
					break;
				case KeyEvent.VK_3:
				case KeyEvent.VK_NUMPAD3:
				case KeyEvent.VK_C:
					state = player.CalcPlayerState(+1, +1);
					break;
				case KeyEvent.VK_4:
				case KeyEvent.VK_NUMPAD4:
				case KeyEvent.VK_A:
					state = player.CalcPlayerState(-1, 0);
					break;
				case KeyEvent.VK_5:
				case KeyEvent.VK_NUMPAD5:
				case KeyEvent.VK_S:
					state = true;
					break;
				case KeyEvent.VK_6:
				case KeyEvent.VK_NUMPAD6:
				case KeyEvent.VK_D:
					state = player.CalcPlayerState(+1, 0);
					break;
				case KeyEvent.VK_7:
				case KeyEvent.VK_NUMPAD7:
				case KeyEvent.VK_Q:
					state = player.CalcPlayerState(-1, -1);
					break;
				case KeyEvent.VK_8:
				case KeyEvent.VK_NUMPAD8:
				case KeyEvent.VK_W:
					state = player.CalcPlayerState(0, -1);
					break;
				case KeyEvent.VK_9:
				case KeyEvent.VK_NUMPAD9:
				case KeyEvent.VK_E:
					state = player.CalcPlayerState(+1, -1);
					break;
				default:
					state = false;
			}
			for (int j = 0; j < enemy.size() && state != true; j++) {
				if (enemy.get(j).getState() == player.getState()) {
					state = false;
					player.setState(player.getOld_x(), player.getOld_y());
				}
			}
		} while (state != true);

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
		// this.player.PrintData();
	}

	private void PrintAllEnemy() {
		int e_state;
		for (int i = 0; i < this.enemy.size(); i++) {
			// this.enemy.get(i).PrintData(i);
			e_state = this.enemy.get(i).getY() * this.game_board.getPanelWIDTH();
			e_state += this.enemy.get(i).getX();
			// System.out.println("[" + i + "]e_state: " + e_state);
			// System.out.println(this.label.size() + "\n");
			switch (this.enemy.get(i).getMove_speed()) {
				case 1:
					this.label.get(e_state).setText("①");
					break;
				case 2:
					this.label.get(e_state).setText("②");
					break;
				default:
					this.label.get(e_state).setText("#");
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
		map.remove((Integer) player.getY() * super.WIDTH + player.getX());
		for (int i = 0; i < enemy.size(); i++) {
			int j;
			for(j = 0;j < map.size();j++) {
				if(map.get(j) == enemy.get(i).getY() * super.WIDTH + enemy.get(i).getX()) break;
			}
			if(j != map.size())map.remove(j);
		}

		// System.out.println("map.size = " + map.size() + "\n");
		state = map.get(Movement.getRndNextInt(map.size()));
		// System.out.println("staet.y : " + state / super.WIDTH + "\nstate.x : " + state % super.WIDTH);
		player.setState(state % super.WIDTH, state / super.WIDTH);

	}

	private void constEnemytoEnemy() {
		int remove_count = 0;

		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		int state, size;
		for (int i = 0; i < super.WIDTH * super.HEIGHT; i++) {
			map.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < enemy.size(); i++) {
			state = enemy.get(i).getY() * super.WIDTH + enemy.get(i).getX();
			map.get(state).add(i);
		}
		for (int i = 0; i < super.WIDTH * super.HEIGHT; i++) {
			size = map.get(i).size();
			if (size > 1) {
				// System.out.println("[" + i + "] : " + size + "\n");
				for (int j = 0; j < size; j++) {
					// System.out.println("ene [" + map.get(i).get(j).intValue() + "] : \n");
					if (j == 0) {
						enemy.get(map.get(i).get(j).intValue()).setMove_speed(0);
					}else {
						enemy.remove(map.get(i).get(j).intValue() - remove_count);
						remove_count++;
					}
				}
			}
		}

	}

	public boolean isNotConstPlayertoEnemy() {
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).getState() == player.getState())
				return false;
		}
		return true;
	}

	public boolean isNotAllEnemyDied() {
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).getMove_speed() != 0)
				return true;
		}
		return false;
	}

	public void GameOverPerform() {
		ArrayList<Integer> map = new ArrayList<Integer>();
		int state;
		Random rnd = new Random();
		for (int i = 0; i < super.HEIGHT * super.WIDTH; i++) {
			map.add(i);
		}
		for (int i = 0; i < label.size(); i++) {
			state = rnd.nextInt(map.size());
			label.get(map.get(state)).setText("①");
			map.remove(state);
		}
	}

	public boolean GameContinue() {
		this.key = game_board.getKey();
		if (this.key == KeyEvent.VK_Y || this.key == KeyEvent.VK_SPACE)
			return true;
		else
			return false;
	}

}
