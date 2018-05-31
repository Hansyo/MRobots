package map.gui;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame extends JFrame implements KeyListener, Runnable {
	final private int WIDTH = 100;
	final private int HEIGHT = 50;
	private int key;
	private boolean key_event;
	private JFrame board = new JFrame("MRobots");

	public Frame() {
		this.board.setBounds(100, 100, WIDTH * 10 + 25, HEIGHT * 10 + 25);
		this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.addKeyListener(this);
		board.setFocusable(true);
	}

	public void addKeyListener(KeyListener l) {
		board.addKeyListener(l);

	}

	public void setVisible(boolean b) {
		this.board.setVisible(b);
	}

	public Container getContentPane() {
		return this.board.getContentPane();
	}

	public int getKey() {
		return this.key;
	}

	@Override
	public void run() {
		requestFocusInWindow();
		while (true) {
			try {
				Thread.sleep(20);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			if (this.key_event == true) break;
		}
		this.key_event = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.key = e.getKeyCode();
		System.out.println("getKey : " + this.key + " " + KeyEvent.VK_0);
		this.key_event = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
