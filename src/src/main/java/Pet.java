public class Pet {

	private String petName;
	private int foodLevel;
	private int entertained;
	private int rested;
	private int experience;
	private int level;
	private int alive;
	private String petType;

	// this is the getter
	public String getPetName() {
		return petName;
	}

	// food changes
	public int getFoodLevel() {
		return foodLevel;
	}

	public void feed() {
		foodLevel = foodLevel + 1;
	}

	public void consume() {
		foodLevel = foodLevel - 1;
	}
	// entertainment changes

	public int getEntertained() {
		return entertained;
	}

	public void attend() {
		entertained = entertained + 1;

	}

	public void neglect() {
		entertained = entertained - 1;

	}

	public int getRested() {
		return rested;
	}

	public void sleep() {
		rested = rested + 1;

	}

	public void active() {
		rested = rested - 1;

	}

	public int getExperience() {
		return experience;
	}

	public void learn() {
		experience = experience + 10;

	}

	public int getLevel() {
		return level;
	}

	public void levelUp() {
		level = level + 1;

	}

	public int getAlive() {
		return alive;
	}

	public String getPetType() {
		return petType;
	}

	public void setExperience() {
		experience = 0;
	}

	// this is my constructor
	public Pet(String petName, int foodLevel, int entertained, int rested, int experience, int level, int alive,
			String petType) {
		this.petName = petName;
		this.foodLevel = foodLevel;
		this.entertained = entertained;
		this.rested = rested;
		this.experience = experience;
		this.level = level;
		this.alive = alive;
		this.petType = petType;
	}

	public String tick() {
		entertained = entertained - 1;
		rested = rested - 1;
		foodLevel = foodLevel - 1;
		if (foodLevel == 0 || entertained == 0 || rested == 0)
			;
		alive = 0;
		return (petName + " is done with that activity");
	}

}
