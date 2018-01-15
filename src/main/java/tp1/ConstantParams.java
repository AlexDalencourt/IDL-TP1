package tp1;

import java.util.Random;

public class ConstantParams {
	
	public static int numberOfNeighbours = 8;
	
	private static Random random = null;
	
	private static SMA sma = null;
	
	public static int getNumberOfParticles() {
		return 10;
	}
	
	public static Random getRandom() {
		if(random == null) {
			random = new Random(5);
		}
		return random;
	}

	public static int getGridSizeX() {
		return 10;
	}

	public static int getGridSizeY() {
		return 10;
	}

	public static boolean getTorus() {
		return false;
	}

	public static SMA getSMA() {
		if(sma == null) {
			sma = new SMASequential();
		}
		return sma;
	}

	public static int getNumberOfTicks() {
		return 10;
	}
}
