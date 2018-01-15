package tp1;

import javax.swing.JFrame;

import tp1.model.ConstantParams;
import view.Displayer;

public class MainGraphicalUI {

	public static void main(String[] args) {
		JFrame windows = new JFrame();
		windows.setVisible(true);
		windows.setSize(ConstantParams.getCanvasSizeX(),ConstantParams.getCanvasSizeY());
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setContentPane(new Displayer());
	}
}
