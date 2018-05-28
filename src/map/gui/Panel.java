package map.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Panel extends map.Map{
	private JPanel panel = new JPanel();

	public Panel() {
		panel.setBackground(Color.GRAY);
	}

	public void Panel_init() {
		Container contentPane = getContentPane();
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		panel.setBorder(border);
		contentPane.add(panel, BorderLayout.NORTH);
	}
}
