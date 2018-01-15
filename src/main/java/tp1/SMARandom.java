package tp1;

public class SMARandom extends SMA {

	@Override
	public void run() {
		agentList.get(ConstantParams.getRandom().nextInt(agentList.size())).decide();
	}

}
