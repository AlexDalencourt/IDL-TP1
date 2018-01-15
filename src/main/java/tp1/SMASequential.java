package tp1;

public class SMASequential extends SMA {

	@Override
	public void run() {
		Agent agent = agentList.remove(0);
		agent.decide();
		agentList.add(agent);
	}

}
