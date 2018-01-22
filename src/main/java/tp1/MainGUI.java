package tp1;

import tp1.model.ConstantParams;
import tp1.model.Environnement;
import tp1.sma.SMA;
import view.MainFrame;

public class MainGUI {

	public static void main(String[] args) throws InterruptedException {
		Environnement env = new Environnement(ConstantParams.getGridSizeX(), ConstantParams.getGridSizeY(), ConstantParams.getTorus());
		SMA sma = ConstantParams.getSMA();
		sma.initAgent(env);

		new MainFrame(env);
		for(int i = 0; i < ConstantParams.getNumberOfTicks();i++) {
			for(int j = 0; j < ConstantParams.getNumberOfParticles(); j++) {
				sma.run();
			}
			Thread.sleep(ConstantParams.getDelay());
		}
	}
}
