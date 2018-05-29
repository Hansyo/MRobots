package map.gui;

import java.awt.Color;
import java.awt.Container;

public class Gui extends map.Map{
	private Frame frame = new Frame();
	private Panel panel = new Panel(Color.RED);
	private Container contentPane;

	public Gui() {
		this.contentPane = this.frame.getContentPane();
	}

	public void SetGameBoard() {
		this.panel.setPreferredSize(WIDTH*10, HEIGHT*10);
		this.panel.setPict(0);
		this.contentPane.add(this.panel.getPanel());
		this.frame.setVisible(true);
	}
}
