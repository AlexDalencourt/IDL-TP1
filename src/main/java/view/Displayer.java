package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import tp1.model.ConstantParams;
import tp1.model.Environnement;

public class Displayer extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5921995227209226746L;

	private Environnement env;
	
	private int frameSizeX;
	
	private int frameSizeY;
	
	public Displayer(Environnement env, int frameSizeX, int frameSizeY) {
		this.env = env;
		this.env.addObserver(this);
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		if(ConstantParams.showGrid()) {
			for(int i = ConstantParams.getBoxSize() + 1; i < ConstantParams.getCanvasSizeX(); i += ConstantParams.getBoxSize() + 1) {
				g.drawLine(i, 0, i, frameSizeY);
			}
			for(int i = ConstantParams.getBoxSize() + 1; i < ConstantParams.getCanvasSizeY(); i += ConstantParams.getBoxSize() + 1) {
				g.drawLine(0, i, frameSizeX, i);
			}
		}
		for(int i = 0; i < env.getEnvironnement().length; i++) {
			for(int j = 0; j < env.getEnvironnement()[i].length; j++) {
				if(env.getEnvironnement()[i][j] != null) {
					drawBall(g,i,j);
				}
			}
		}
	}
	
	private void drawBall(Graphics g,int x, int y) {
		int posX = (ConstantParams.getBoxSize() + 1) * x;
		int posY = (ConstantParams.getBoxSize() + 1) * y;
		g.fillOval(posX, posY, ConstantParams.getBoxSize() + 1, ConstantParams.getBoxSize() + 1);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(env.getTick() % ConstantParams.refresh() == 0) {
			repaint();	
		}
	}
}
