package tp1;

import tp1.model.ConstantParams;
import tp1.model.Environnement;
import tp1.sma.SMA;

public class Main {

	public static void main(String[] args) {
		Environnement env = new Environnement(ConstantParams.getGridSizeX(), ConstantParams.getGridSizeY(), ConstantParams.getTorus());
		SMA sma = ConstantParams.getSMA();
		sma.initAgent(env);
		System.out.println(env);
		System.out.println("---");
		for(int i = 0; i < ConstantParams.getNumberOfTicks();i++) {
			sma.run();
			System.out.println(env);
			System.out.println("---");
		}
	}
}
