package com.nurserygarden.ecommerceapp.entities_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nurserygarden.ecommerceapp.entities_demo.entities.Person;
import com.nurserygarden.ecommerceapp.entities_demo.entities.Pet;
import com.nurserygarden.ecommerceapp.entities_demo.repositories.PersonRepository;
import com.nurserygarden.ecommerceapp.entities_demo.repositories.PetRepository;
import com.nurserygarden.ecommerceapp.entities_demo.responses.PersonResponse;
import com.nurserygarden.ecommerceapp.entities_demo.responses.PetResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntitiesDemoApplication implements CommandLineRunner {

	private final PersonRepository personRepository;
	private final PetRepository petRepository;

	public EntitiesDemoApplication(PersonRepository personRepository, PetRepository petRepository) {
		this.personRepository = personRepository;
		this.petRepository = petRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EntitiesDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new JavaTimeModule());

		Pet newton = petRepository.findById(1L).get();

		Person leo = new Person();
		leo.setFirstName("Maria");
		leo.setLastName("Salas");
		leo.setPet(newton);

		Person personCreated = personRepository.save(leo);
		PersonResponse personResponse = toPersonResponse(personCreated);

		System.out.println("Save person: " + objectMapper.writeValueAsString(personResponse));
	}

	private PersonResponse toPersonResponse(Person person) {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setId(person.getId());
		personResponse.setFirstName(person.getFirstName());
		personResponse.setLastName(person.getLastName());
		personResponse.setCreatedAt(person.getCreatedAt());
		personResponse.setUpdatedAt(person.getUpdatedAt());
		personResponse.setPetName(person.getPet().getName());
		return personResponse;
	}

	private PetResponse toPetResponse(Pet pet) {
		PetResponse petResponse = new PetResponse();
		petResponse.setId(pet.getId());
		petResponse.setName(pet.getName());
		petResponse.setCreatedAt(pet.getCreatedAt());
		petResponse.setUpdatedAt(pet.getUpdatedAt());
		return petResponse;
	}
}
