package tp1.model;

import java.util.Random;

import tp1.sma.SMA;
import tp1.sma.SMASequential;

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

	public static int getCanvasSizeX() {
		return 500;
	}

	public static int getCanvasSizeY() {
		return 500;
	}

	public static int getBoxSize() {
		return 50;
	}

	public static long getDelay() {
		return 1000;
	}
}
