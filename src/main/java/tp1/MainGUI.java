package tp1;

import tp1.model.ConstantParams;
import tp1.model.Environnement;
import tp1.sma.SMA;
import view.MainFrame;

public class MainGUI {

	public static void main(String[] args) throws InterruptedException {
		Environnement env = new Environnement(ConstantParams.getGridSizeX(), ConstantParams.getGridSizeY(),
				ConstantParams.getTorus());
		SMA sma = ConstantParams.getSMA();
		sma.initAgent(env);

		new MainFrame(env);
		Thread.sleep(ConstantParams.getDelay());
		while (true) {
			if (ConstantParams.getNumberOfTicks() != 0 && env.getTick() < ConstantParams.getNumberOfTicks()) {
				break;
			}
			executeOneTick(sma);
		}
	}

	private static void executeOneTick(SMA sma) throws InterruptedException {
		for (int j = 0; j < ConstantParams.getNumberOfParticles(); j++) {
			sma.run();
		}
		Thread.sleep(ConstantParams.getDelay());
	}
}
