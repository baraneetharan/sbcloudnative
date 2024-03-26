package com.leads.sbcloudnative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SbcloudnativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbcloudnativeApplication.class, args);
	}
}

@RestController
class PersonController {
	private final PersonRepository personRepository;

	@Autowired
	PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		System.out.println("######################");
		System.out.println(personRepository.findAll());
		return personRepository.findAll();
	}
}

record Person(@Id Long id, String uname, String email) {
}

interface PersonRepository extends ListCrudRepository<Person, Long> {
}