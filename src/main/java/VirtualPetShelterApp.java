import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();
		VirtualPetShelter notSheltered = new VirtualPetShelter();
		PetStatus myStatus = new PetStatus();
		Resource myResource = new Resource(0, 0, 0, 0, 0, "");
		String menuOption;

		Pet pet1 = new Pet("1234", "Bob", 5, 2, 3, 3, 0, 1, 1, "Laid-back", "A bit fluffy, but seems kind hearted");
		Pet pet2 = new Pet("1235", "Sally", 5, 2, 3, 3, 0, 1, 1, "Curios", "With wide eyes, constantly");
		Pet pet3 = new Pet("1236", "Fluffy", 5, 2, 3, 3, 0, 1, 1, "Basic", "Your run of the mill cat.");
		Pet pet4 = new Pet("1237", "Rolf", 5, 2, 3, 3, 0, 1, 1, "Big Appetited",
				"A giant furry dog, who can play the piano");
		Pet pet5 = new Pet("1238", "Kirk", 5, 2, 3, 3, 0, 1, 1, "High Maintenance",
				"seems over confident for his size.");
		Pet pet6 = new Pet("1239", "Archer", 5, 2, 3, 3, 0, 1, 1, "Curious", "runs around a lot");
		Pet pet7 = new Pet("1240", "Picard", 5, 2, 3, 3, 0, 1, 1, "Lazy",
				"finds the highest thing in the room to sit on.");
		Pet pet8 = new Pet("1241", "Janeway", 5, 2, 3, 3, 0, 1, 1, "Laid-back", "likes to be by herself.");
		
		myShelter.add(pet1);
		myShelter.add(pet2);
		myShelter.add(pet3);
		myShelter.add(pet4);
		Collection<Pet> pets = myShelter.getAllPets();

		notSheltered.add(pet5);
		notSheltered.add(pet6);
		notSheltered.add(pet7);
		notSheltered.add(pet8);
		Collection<Pet> freepets = notSheltered.getAllPets();

		System.out.println("Congratulations! You just openned a pet shelter. Here are your pets:");
		System.out.println("Name\t|Hunger\t\t|Entertainment\t|Thirst\t |Rest\t|Personality");
		System.out.println("--------|---------------|---------------|--------|------|-------------");
		for (Pet pet : pets) {
			System.out.println(pet.getPetName() + "\t|" + myStatus.getHungerStatus(pet.getFoodLevel()) + "\t|"
					+ myStatus.getEntertainmentStatus(pet.getEntertained()) + "\t\t|" + pet.getWater() + "\t |"
					+ myStatus.getRestedStatus(pet.getRested()) + "|" + pet.getPetType());
		}
		System.out.println("\n\nWhat would you like to do?\n");
		do {
			System.out.println("1 - Check on your pets.");
			System.out.println("2 - Feed your pets.");
			System.out.println("3 - Give your pets water.");
			System.out.println("4 - Play with a specific pet.");
			System.out.println("5 - Train yor pets.");
			System.out.println("6 - Put your pets to sleep.");
			System.out.println("7 - Admit a new pet to the shelter");
			System.out.println("8 - Let someone adopt a pet");
			System.out.println("9 - Go out drinking and leave your pets to their own devices.");
			System.out.println("10 - Abandon your shelter and let the pets run wild.");
			menuOption = input.nextLine();
			if (menuOption.equals("1")) {
				System.out.println("\n\nName\t|Hunger\t\t|Entertainment\t|Thirst\t |Rest\t|Personality");
				System.out.println("--------|---------------|---------------|--------|------|-------------");
				for (Pet pet : pets) {
					System.out.println(pet.getPetName() + "\t|" + myStatus.getHungerStatus(pet.getFoodLevel()) + "\t|"
							+ myStatus.getEntertainmentStatus(pet.getEntertained()) + "\t\t|" + pet.getWater() + "\t |"
							+ myStatus.getRestedStatus(pet.getRested()) + "|" + pet.getPetType());
				}
			}

			else if (menuOption.equals("2")) {
				myShelter.feedAll();
			}

			else if (menuOption.equals("3")) {
				myShelter.waterAll();
			}

			else if (menuOption.equals("4")) {
				System.out.println("Which pet would you like to play with?(enter your pet's tag number");
				for (Pet pet : pets) {
					System.out.println(pet.getPetName() + ", " + pet.getPetDescription() + ": " + pet.getPetTag());
				}
				String petChoice = input.nextLine();
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pet is not interested in playing right now.");
					break;
				}
				myShelter.trainOne(petChoice);
			}

			else if (menuOption.equals("5")) {
				if (myResource.getLastChoice() == "entertained") {
					System.out.println("Your pets are not learning anything more right now.");
					break;
				} else {
					myShelter.trainAll();
					myShelter.trainAll();
				}
			}

			else if (menuOption.equals("6")) {
				if (myResource.getLastChoice() == "rested") {
					System.out.println("Your pets are not interested in going back to sleep.");
					break;
				} else {
					myShelter.restAll();
					myShelter.restAll();
					myShelter.restAll();
				}
			}

			else if (menuOption.equals("7")) {
				if (pets.size() < 9) {
					if(freepets.contains(pet5)) {
					myShelter.add(pet5);
					notSheltered.remove(pet5);
				
					}
					else if(freepets.contains(pet6)){
						myShelter.add(pet6);
						notSheltered.remove(pet6);
					}
					else if(freepets.contains(pet7)){
						myShelter.add(pet7);
						notSheltered.remove(pet7);
					}
					else{
						myShelter.add(pet8);
						notSheltered.remove(pet8);
					}
				} else
					System.out.println("Your Shelter is full, and cannot accept more pets.");

			} else if (menuOption.equals("8")) {
				if (freepets.size() != 8) {
					if(pets.contains(pet1)) {
					notSheltered.add(pet1);
					myShelter.remove(pet1);
				
					}
					else if(pets.contains(pet2)) {
						notSheltered.add(pet2);
						myShelter.remove(pet2);
						}
					else if(pets.contains(pet3)) {
						notSheltered.add(pet3);
						myShelter.remove(pet3);
					
						}
					else if(pets.contains(pet4)) {
						notSheltered.add(pet4);
						myShelter.remove(pet4);
					
						}
					else if(pets.contains(pet5)) {
						notSheltered.add(pet5);
						myShelter.remove(pet5);
					
						}
					else if(pets.contains(pet6)) {
						notSheltered.add(pet6);
						myShelter.remove(pet6);
					
						}
					else if(pets.contains(pet7)) {
						notSheltered.add(pet7);
						myShelter.remove(pet7);
					
						}
					else{
						notSheltered.add(pet8);
						myShelter.remove(pet8);
					}
				} else
					System.out.println("There are no pets currently available in your shelter.");
			}

			else if (menuOption.equals("9")) {
				myShelter.tickAll();
			} else {
				System.out.println(
						"The police show up on your door 20 minutes later and you are arrested for animal endangerment.");
				System.exit(0);
			}
			System.out.println("What else do you want to do?");
			myResource.setTickCount();

		} while (menuOption != "10");
		input.close();
	}

}
