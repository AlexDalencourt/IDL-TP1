package tp1.sma;

import tp1.model.Agent;

public class SMASequential extends SMA {

	@Override
	public void run() {
		Agent agent = agentList.remove(0);
		agent.decide();
		agentList.add(agent);
	}

}
