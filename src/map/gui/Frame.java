package map.gui;

import javax.swing.JFrame;

import map.Map;


public class Frame extends Map {
	JFrame board = new JFrame("MRobots");

	public Frame() {
		board.setBounds(100, 100, WIDTH * 4, HEIGHT * 4);
	}

	public void setVisible() {
		board.setVisible(true);
	}
}
