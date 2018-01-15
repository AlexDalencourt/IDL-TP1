package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tp1.model.ConstantParams;

public class Displayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5921995227209226746L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		for(int i = 0; i < (ConstantParams.getCanvasSizeX() / ConstantParams.getBoxSize()); i += ConstantParams.getBoxSize()) {
			g.drawLine(0, i, 0, ConstantParams.getCanvasSizeY());
		}
		for(int i = 0; i < (ConstantParams.getCanvasSizeY() / ConstantParams.getBoxSize()); i += ConstantParams.getBoxSize()) {
			g.drawLine(i, 0, ConstantParams.getCanvasSizeX(), 0);
		}
	}
}
