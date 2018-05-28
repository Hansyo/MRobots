package map.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel extends map.Map{
	private JPanel panel = new JPanel();

	public Panel(Color color) {
		panel.setBackground(color);
	}

	public void setPreferredSize(int width,int height) {
		panel.setPreferredSize(new Dimension(width, height));
	}

	public JPanel getPanel() {
		return panel;
	}


}
