package tp1;

import java.util.ArrayList;
import java.util.List;

public class SMASequentialRandom extends SMA{
	
	private final List<Agent> saveStack = new ArrayList<>();

	@Override
	public void run() {
		if(agentList.size() == 0) {
			agentList.addAll(saveStack);
			saveStack.clear();
		}
		Agent agent = agentList.remove(ConstantParams.getRandom().nextInt(agentList.size()));
		saveStack.add(agent);
		agent.decide();
	}

}
