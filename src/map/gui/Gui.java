package map.gui;

import java.awt.Color;
import java.awt.Container;

public class Gui extends map.Map{
	private Frame frame = new Frame();
	private Panel panel = new Panel(Color.RED);
	private Container contentPane;

	public Gui() {
		contentPane = frame.getContentPane();
	}

	public void SetGameBoard() {
		panel.setPreferredSize(WIDTH, HEIGHT);
		contentPane.add(panel.getPanel());
		frame.setVisible(true);
	}
}
