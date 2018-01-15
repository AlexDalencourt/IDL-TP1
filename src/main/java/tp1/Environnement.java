package tp1;

public class Environnement {
	private Agent[][] environnement;
	
	private boolean torus;
	
	public Environnement(int x, int y, boolean torus) {
		this.environnement = new Agent[x][y];
		this.torus = torus;
	}

	public boolean isEmptyCellule(int x, int y) {
		if((x < 0 || y < 0) && !torus) {
			return false;
		}
		else if (torus) {
			if(x < 0) {
				x = ConstantParams.getGridSizeX() - 1;
			}
			if(y < 0) {
				y = ConstantParams.getGridSizeY() - 1;
			}
		}
		return null == environnement[x][y];
	}
	
	public void applyTransition(Agent agent) {
		environnement[agent.getPosX()][agent.getPosY()] = null;
		agent.update();
		environnement[agent.getPosX()][agent.getPosY()] = agent;
	}
	
	@Override
	public String toString() {
		String output = "";
		int scale = String.valueOf(ConstantParams.getNumberOfParticles()).length();
		for(int i = 0; i < environnement.length; i++) {
			for(int j = 0; j < environnement[i].length; j++) {
				output += "|";
				if(environnement[i][j] != null) {
					output += environnement[i][j].getId();
				}
				for(int k = 0; k < (environnement[i][j] != null ? scale - String.valueOf(environnement[i][j].getId()).length() : scale); k++) {
					output += " ";
				}
			}
			output += "|\n";
		}
		return output;
	}
}
