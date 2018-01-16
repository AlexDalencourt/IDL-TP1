package tp1;

import tp1.model.ConstantParams;

public class Logger {

	public static void log(Object in) {
		if(ConstantParams.showTrace()) {
			System.out.println(in);
		}
	}
}
