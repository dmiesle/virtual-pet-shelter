import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PetStatus myStatus = new PetStatus();
		String menuOption;

		System.out.println("Congratulations! You just found a new pet.");
		System.out.println("Your new pet needs a name. Please give it one now:");
		String name = input.nextLine();
		String personality = myStatus.getPersonality();
		Pet myPet = new Pet("1234", name, 5, 2, 3, 0, 1, 1, personality, "needs description");
		Resource myResource = new Resource(0, 0, 0, 0, 0, "");
		System.out.println(name + " is so excited you are going to care for it. Your pet is " + myPet.getPetType());
		System.out.println(name + " a" + myPet.getPetDescription()+ " "+ name + " is " + myStatus.getHungerStatus(myPet.getFoodLevel()) + " , is feeling "
				+ myStatus.getEntertainmentStatus(myPet.getEntertained()) + ", and has enough rest that they are "
				+ myStatus.getRestedStatus(myPet.getRested()) + ".");
		System.out.println("Right now " + name + " is waiting for you to do something");
		do {
			System.out.println("1 - Check on " + name + ".");
			System.out.println("2 - Feed " + name + ".");
			System.out.println("3 - Play with " + name + ".");
			System.out.println("4 - Train " + name + ".");
			System.out.println("5 - Put " + name + " to sleep.");
			System.out.println("6 - Ignore " + name + ".");
			System.out.println("7 - Abandon " + name + ".");
			menuOption = input.nextLine();

			if (menuOption.equals("1")) {
				System.out.println(name + " is " + myStatus.getHungerStatus(myPet.getFoodLevel()) + " , is feeling "
						+ myStatus.getEntertainmentStatus(myPet.getEntertained())
						+ ", and has enough energy that they are " + myStatus.getRestedStatus(myPet.getRested()) + ".");
			} else if (menuOption.equals("2")) {
				myPet.feed();
			} else if (menuOption.equals("3")) {
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pet is not learning anything more right now.");
					break;
				} else {
					myPet.attend();
					myPet.attend();
					if (myPet.getExperience() >= 100) {
						myPet.levelUp();
						myPet.setExperience();
						System.out
								.println("Congratulations! " + name + "Has just gained enough experience to level up. "
										+ name + " is now level" + myPet.getLevel() + "!");
					}
					if (myPet.getAlive() != 1) {
						System.out.println("Your pet has died. Goodbye");
						System.exit(0);
					}
				}
				
			} else if (menuOption.equals("4")) {
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pet is not interested in playing right now.");
					break;
				} else {
					myPet.learn();
					myPet.learn();
					if (myPet.getExperience() >= 100) {
						myPet.levelUp();
						myPet.setExperience();
						System.out
								.println("Congratulations! " + name + "Has just gained enough experience to level up. "
										+ name + " is now level" + myPet.getLevel() + "!");
					}
					if (myPet.getAlive() != 1) {
						System.out.println("Your pet has died. Goodbye");
						System.exit(0);
					}
				}
				
			} else if (menuOption.equals("5")) {
				if (myResource.getLastChoice() == "rested") {
					System.out.println("Your pet is not interested in going back to sleep.");
					break;
				} else {
					myPet.sleep();
					myPet.sleep();
					myPet.sleep();
					if (myPet.getAlive() != 1) {
						System.out.println("Your pet has died. Goodbye");
						System.exit(0);
					}
				}
			} else if (menuOption.equals("6")) {
				myPet.tick();
				if (myPet.getAlive() != 1) {
					System.out.println("Your pet has died. Goodbye");
					System.exit(0);
				}
			} else {
				System.out.println("Your pet wanders off to find someone who cares about living beings.");
				System.exit(0);
			}
			System.out.println("What else do you want to do with " + name + "?");
			myResource.setTickCount();
			if (myResource.getLastTick() == (10 / myPet.getLevel())) {
				myPet.tick();
			}
		} while (menuOption != "7");
		input.close();

	}
}
