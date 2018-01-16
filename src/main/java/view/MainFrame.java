package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import tp1.model.ConstantParams;
import tp1.model.Environnement;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 8456560429229699542L;

	private Environnement env;
	
	private Displayer displayer;
	
	public MainFrame (Environnement env) {
		this.env = env;
		
		init();
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init() {
		int sizeX = ConstantParams.getCanvasSizeX();
		int sizeY = ConstantParams.getCanvasSizeY();
		displayer = new Displayer(env, sizeX+100, sizeY+100);
		displayer.setPreferredSize(new Dimension(sizeX+100, sizeY+100));
		JScrollPane panel = new JScrollPane(displayer);
		panel.getViewport().setPreferredSize(new Dimension(sizeX,sizeY));
		setContentPane(panel);
	}
	
}
