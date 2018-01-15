package tp1.model;

public class Agent {
	private int id;

	private Environnement env;

	private int posX;

	private int posY;

	private int pasX;

	private int pasY;

	public Agent(int id, int posX, int posY, Environnement env) {
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		this.env = env;
		this.env.putAgent(this);
	}

	public int getId() {
		return id;
	}

	public void decide() {
		boolean[][] testValues = new boolean[3][3];
		int nbTestScale = 0;
		pasX = 1;
		pasY = 1;
		do {
			while((pasX == 1 && pasY == 1) || testValues[pasX][pasY]) {
				pasX = ConstantParams.getRandom().nextInt(3);
				pasY = ConstantParams.getRandom().nextInt(3);
			}
			testValues[pasX][pasY] = true;
			nbTestScale++;
			if(env.isEmptyCellule(getNewPosX(), getNewPosY())) {
				break;
			}
			pasX = (pasX - 1) * -1 + 1;
			pasY = (pasY - 1) * -1 + 1;
			if(testValues[pasX][pasY]) {
				pasX = 1;
				pasY = 1;
			} else {
				testValues[pasX][pasY] = true;
				nbTestScale++;
			}
		} while (nbTestScale < ConstantParams.numberOfNeighbours);
		env.applyTransition(this);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNewPosX() {
		return this.posX + this.pasX - 1;
	}
	
	public int getNewPosY() {
		return this.posY + this.pasY - 1;
	}

	public void update() {
		this.posX = this.getNewPosX();
		this.posY = this.getNewPosY();
		this.pasX = 1;
		this.pasY = 1;
	}
}
