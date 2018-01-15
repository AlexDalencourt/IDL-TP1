package tp1.sma;

import tp1.model.ConstantParams;

public class SMARandom extends SMA {

	@Override
	public void run() {
		agentList.get(ConstantParams.getRandom().nextInt(agentList.size())).decide();
	}

}
