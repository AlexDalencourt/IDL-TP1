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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init() {
		int sizeX = ConstantParams.getCanvasSizeX();
		int sizeY = ConstantParams.getCanvasSizeY();
		displayer = new Displayer(env);
		JScrollPane scrollPanel = new JScrollPane(displayer);
		setContentPane(scrollPanel);
		this.setSize(new Dimension(sizeX,sizeY));
	}
	
}
