package com.afip.person.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afip.person.models.PersonModel;
import com.afip.person.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonControler {

	@Autowired
	PersonService personService;

	@GetMapping()
	public ArrayList<PersonModel> getPersons() {
		return personService.getPersons();
	}

	@PostMapping()
	public PersonModel postPersons(@RequestBody PersonModel person) {
		return personService.postPerson(person);
	}

	@GetMapping(path = "/{id}")
	public Optional<PersonModel> getPersonById(@PathVariable("id") Long id) {
		return personService.getForId(id);
	}

	@GetMapping("/query")
	public ArrayList<PersonModel> getPersonByCuil(@RequestParam("cuil") String cuil) {
		return personService.getForCuil(cuil);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteForId(@PathVariable("id") Long id) {

		String message;

		if (personService.deletePerson(id))

			message = "Se eliminó el usuario con id" + id;

		else

			message = "No se pudo eliminar el usuario con id" + id;

		return message;
	}
}