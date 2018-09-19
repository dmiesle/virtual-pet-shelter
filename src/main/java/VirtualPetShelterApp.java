import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();
		PetStatus myStatus = new PetStatus();
		Resource myResource = new Resource(0, 0, 0, 0, 0, "");
		String menuOption;
		
		Pet pet1 = new Pet("1234", "Bob", 5, 2, 3, 3, 0, 1, 1, "Laid-back", "A bit fluffy, but seems kind hearted");
		Pet pet2 = new Pet("1235", "Sally", 5, 2, 3, 3, 0, 1, 1, "Curios", "With wide eyes, constantly");
		Pet pet3 = new Pet("1236", "Fluffy", 5, 2, 3, 3, 0, 1, 1, "Basic", "Your run of the mill cat.");
		Pet pet4 = new Pet("1237", "Rolf", 5, 2, 3, 3, 0, 1, 1, "Big Appetited", "A giant furry dog, who can play the piano");
		myShelter.add(pet1);
		myShelter.add(pet2);
		myShelter.add(pet3);
		myShelter.add(pet4);
		Collection<Pet> pets =myShelter.getAllPets();
		
		
		System.out.println("Congratulations! You just openned a pet shelter. Here are your pets:");
		System.out.println("Name\t|Hunger\t\t|Entertainment\t|Thirst\t |Rest\t|Personality");
		System.out.println("--------|---------------|---------------|--------|------|-------------");
		for (Pet pet : pets) {
			System.out.println(pet.getPetName() + "\t|" + myStatus.getHungerStatus(pet.getFoodLevel())+ "\t|" + myStatus.getEntertainmentStatus(pet.getEntertained()) + "\t\t|"
					+ pet.getWater() + "\t |" + myStatus.getRestedStatus(pet.getRested())+ "|" + pet.getPetType());
		}
		System.out.println("\n\nWhat would you like to do?\n");
		do {
			System.out.println("1 - Check on your pets.");
			System.out.println("2 - Feed your pets.");
			System.out.println("3 - Play with a specific pet.");
			System.out.println("4 - Train yor pets.");
			System.out.println("5 - Put your pets to sleep.");
			System.out.println("6 - Go out drinking and leave them to their own devices.");
			System.out.println("7 - Abandon your shelter and let the pets run wild.");
			menuOption = input.nextLine();
			if (menuOption.equals("1")) {
				System.out.println("Name\t|Hunger\t\t|Entertainment\t|Thirst\t |Rest\t|Personality");
				System.out.println("--------|---------------|---------------|--------|------|-------------");
				for (Pet pet : pets) {
					System.out.println(pet.getPetName() + "\t|" + myStatus.getHungerStatus(pet.getFoodLevel())+ "\t|" + myStatus.getEntertainmentStatus(pet.getEntertained()) + "\t\t|"
							+ pet.getWater() + "\t |" + myStatus.getRestedStatus(pet.getRested())+ "|" + pet.getPetType());
				}}
			
			else if (menuOption.equals("2")) {
				myShelter.feedAll();
				
			}
			else if (menuOption.equals("3")) {
				System.out.println("Which pet would you like to play with?(enter your pet's tag number");
				for (Pet pet : pets) {
					System.out.println(pet.getPetName()+ ": " + pet.getPetTag());
				}
				String petChoice = input.nextLine();
			}
			}
	}

}
