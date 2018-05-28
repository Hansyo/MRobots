package map.gui;

import java.awt.Container;

import javax.swing.JFrame;

import map.Map;


public class Frame extends Map {
	private JFrame board = new JFrame("MRobots");

	public Frame() {
		this.board.setBounds(100, 100, WIDTH * 10 + 25, HEIGHT * 10 + 25);
	}

	public void setVisible(boolean b) {
		this.board.setVisible(b);
	}

	public Container getContentPane() {
		return this.board.getContentPane();
	}
}
