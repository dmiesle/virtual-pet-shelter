import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	Pet pet1;
	Pet pet2;
	Resource resource;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new Pet("1234", "Bob", 5, 2, 3, 3, 0, 1, 1, "Basic", "nothing special");
		pet2 = new Pet("1235", "Sally", 5, 2, 3, 3, 0, 1, 1, "Basic", "needs description");
	}

	@Test
	public void addAPetToTheShelter() {
		underTest.add(pet1);
		String retrievedPet = underTest.findPet("1234");
		assertThat(retrievedPet, is("1234"));
	}
	
	@Test
	public void addTwoPetsToTheShelter() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<Pet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}
	
	@Test
	public void removePetFromTheShelter() {
		underTest.add(pet1);
		underTest.remove(pet1);
		int retrievedPet = underTest.pets.size();
		assertThat(retrievedPet, is(0));
	}
	@Test
	public void feedAllPetsInTheShelter() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.feedAll();
		int retrievedPet = pet1.getFoodLevel();
		int retrievedPet2 = pet2.getFoodLevel();
		assertThat(retrievedPet, is(6));
		assertThat(retrievedPet2, is(6));

	}
	@Test
	public void trainAllPetsInTheShelter() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.trainAll();
		int retrievedPet = pet1.getEntertained();
		int retrievedPet2 = pet2.getEntertained();
		assertThat(retrievedPet, is(3));
		assertThat(retrievedPet2, is(3));

	}
	
	@Test
	public void giveWaterToAllPetsInTheShelter() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.waterAll();
		int retrievedPet = pet1.getWater();
		int retrievedPet2 = pet2.getWater();
		assertThat(retrievedPet, is(4));
		assertThat(retrievedPet2, is(4));

	}
	
	@Test
	public void playWithOnePetInTheShelter() {
		underTest.add(pet1);
		underTest.trainOne(pet1.getPetTag());
		int retrievedPet = pet1.getEntertained();
		assertThat(retrievedPet, is(3));
	}

}
