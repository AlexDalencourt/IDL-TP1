package tp1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import tp1.sma.SMA;
import tp1.sma.SMARandom;
import tp1.sma.SMASequential;
import tp1.sma.SMASequentialRandom;

public class ConstantParams {
	
	public static int numberOfNeighbours = 8;
	
	private static Random random = null;
	
	private static SMA sma = null;

	private static Properties props;
	
	static {
		Scanner scan = new Scanner(System.in);
		System.out.println("Path to properties file");
//		String path = scan.nextLine();
		String path = "src/main/resources/param.properties";
		scan.close();
		props = new Properties();
		try {
			props.load(new FileInputStream(new File(path)));
		} catch (IOException e) {
			throw new RuntimeException("Bad path to properties");
		}
	}
	
	public static int getNumberOfParticles() {
		return Integer.valueOf(props.getProperty("nb.particles"));
	}
	
	public static Random getRandom() {
		if(random == null) {
			int seed = Integer.valueOf(props.getProperty("seed"));
			if(seed != 0) {
				random = new Random(5);
			}else {
				random = new Random(System.currentTimeMillis());
			}
		}
		return random;
	}

	public static int getGridSizeX() {
		return Integer.valueOf(props.getProperty("grid.size.x"));
	}

	public static int getGridSizeY() {
		return Integer.valueOf(props.getProperty("grid.size.y"));
	}

	public static boolean getTorus() {
		return Boolean.getBoolean(props.getProperty("torus"));
	}

	public static SMA getSMA() {
		if(sma == null) {
			switch (SMATypes.valueOf(props.getProperty("scheduling"))) {
			case SEQUENTIAL:
				sma = new SMASequential();
				break;
			case SEQUENTIALRANDOM:
				sma = new SMASequentialRandom();
				break;
			case ALLRANDOM:
			default:
				sma = new SMARandom();
				break;
			}
		}
		return sma;
	}

	public static int getNumberOfTicks() {
		return Integer.valueOf(props.getProperty("nb.ticks"));
	}

	public static int getCanvasSizeX() {
		return Integer.valueOf(props.getProperty("canvas.size.x"));
	}

	public static int getCanvasSizeY() {
		return Integer.valueOf(props.getProperty("canvas.size.y"));
	}

	public static int getBoxSize() {
		return Integer.valueOf(props.getProperty("box.size"));
	}

	public static long getDelay() {
		return Long.valueOf(props.getProperty("delay"));
	}
	
	public static boolean showGrid() {
		return Boolean.valueOf(props.getProperty("grid"));
	}
	
	public static boolean showTrace() {
		return Boolean.valueOf(props.getProperty("trace"));
	}
	
	public static int refresh() {
		return Integer.valueOf(props.getProperty("refresh"));
	}
	
	private enum SMATypes {
		SEQUENTIAL, SEQUENTIALRANDOM, ALLRANDOM
	}
}
