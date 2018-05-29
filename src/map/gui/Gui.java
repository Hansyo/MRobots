package map.gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;

public class Gui extends map.Map{
	private Frame frame = new Frame();
	private Panel panel = new Panel(Color.RED);
	private Container contentPane;

	public Gui() {
		this.contentPane = this.frame.getContentPane();
	}

	public void setGameBoard() {
		this.panel.setPreferredSize(WIDTH*10, HEIGHT*10);
		this.contentPane.add(this.panel.getPanel());
	}

	public void addLabeltoPanel(JLabel label) {
		panel.addLabel(label);
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(b);
	}

	public int getGridSize() {
		return this.panel.getHEIGHT() * this.panel.getWIDTH();
	}

	public int getPanelHEIGHT() {
		return this.panel.getHEIGHT();
	}

	public int getPanelWIDTH() {
		return this.panel.getWIDTH();
	}

}
