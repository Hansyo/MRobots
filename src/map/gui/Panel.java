package map.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel {
	private JPanel panel = new JPanel();
	private final int GAP = 2;
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	private GridLayout grid = new GridLayout(WIDTH, HEIGHT, GAP, GAP);

	public Panel(Color color) {
		this.panel.setBackground(color);
		this.panel.setLayout(this.grid);
	}

	public void setPreferredSize(int width,int height) {
		this.panel.setPreferredSize(new Dimension(width, height));
	}

	public JPanel getPanel() {
		return this.panel;
	}

	/* labelを複数作って書き換えれば良いという説が提唱された。*/
	public void addLabel(JLabel label) {
		this.panel.add(label);
	}
}
