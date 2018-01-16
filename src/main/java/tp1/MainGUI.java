package tp1;

import java.awt.Dimension;
import java.math.BigDecimal;

import javax.swing.JFrame;

import tp1.model.ConstantParams;
import tp1.model.Environnement;
import tp1.sma.SMA;
import view.Displayer;

public class MainGUI {

	public static void main(String[] args) throws InterruptedException {
		Environnement env = new Environnement(ConstantParams.getGridSizeX(), ConstantParams.getGridSizeY(), ConstantParams.getTorus());
		SMA sma = ConstantParams.getSMA();
		sma.initAgent(env);
		JFrame windows = new JFrame();
		windows.setVisible(true);
		int sizeX = ConstantParams.getCanvasSizeX();
		int sizeY = ConstantParams.getCanvasSizeY();
		sizeX = sizeX + (new BigDecimal(sizeX).divide(new BigDecimal(ConstantParams.getBoxSize()), BigDecimal.ROUND_UP).intValue() - 1);
		sizeY = sizeY + (new BigDecimal(sizeY).divide(new BigDecimal(ConstantParams.getBoxSize()), BigDecimal.ROUND_UP).intValue() - 1);
		Displayer displayer = new Displayer(env,sizeX,sizeY);
		displayer.setPreferredSize(new Dimension(sizeX, sizeY));
		windows.setContentPane(displayer);
		windows.pack();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 0; i < ConstantParams.getNumberOfTicks();i++) {
			sma.run();
			Thread.sleep(ConstantParams.getDelay());
		}
	}
}
