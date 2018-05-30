package map.gui;

import java.awt.Container;

import javax.swing.JFrame;

public class Frame {
	final private int WIDTH = 100;
	final private int HEIGHT = 50;
	private JFrame board = new JFrame("MRobots");

	public Frame() {
		this.board.setBounds(100, 100, WIDTH * 10 + 25, HEIGHT * 10 + 25);
		this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		this.board.setVisible(b);
	}

	public Container getContentPane() {
		return this.board.getContentPane();
	}
}
