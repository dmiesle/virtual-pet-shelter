import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	Map<String, Pet> pets = new HashMap<>();
	Resource resource;

	public void add(Pet petTag) {
		pets.put(petTag.getPetTag(), petTag);

	}

	public String findPet(String petTag) {
		return petTag;
	}

	public Collection<Pet> getAllPets() {
		return pets.values();
	}

	public void remove(Pet petTag) {
		pets.remove(petTag.getPetTag());

	}

	public void feedAll() {
		for (Entry<String, Pet> entry : pets.entrySet()) {
			entry.getValue().feed();
		}

	}

	public void trainAll() {
		for (Entry<String, Pet> entry : pets.entrySet()) {
			entry.getValue().attend();
		}

	}

	public void trainOne(String petTag) {
		pets.get(petTag).attend();

	}

	public void waterAll() {
		for (Entry<String, Pet> entry : pets.entrySet()) {
			entry.getValue().water();
		}

	}

}
