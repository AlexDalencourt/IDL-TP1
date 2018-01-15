package tp1.sma;

import java.util.ArrayList;
import java.util.List;

import tp1.model.Agent;
import tp1.model.ConstantParams;
import tp1.model.Environnement;

public abstract class SMA {
	protected final List<Agent> agentList = new ArrayList<>();

	abstract public void run();

	public void initAgent(Environnement env) {
		if (ConstantParams.getGridSizeX() * ConstantParams.getGridSizeY() < ConstantParams.getNumberOfParticles()) {
			throw new IllegalArgumentException("Nombre de particules supérieur au nombre de cases du tableau");
		}
		for (int i = 0; i < ConstantParams.getNumberOfParticles(); i++) {
			int posX, posY;
			do {
				posX = ConstantParams.getRandom().nextInt(ConstantParams.getGridSizeX());
				posY = ConstantParams.getRandom().nextInt(ConstantParams.getGridSizeY());
			} while (!env.isEmptyCellule(posX, posY));
			agentList.add(new Agent(i, posX, posY, env));
		}
	}
}
