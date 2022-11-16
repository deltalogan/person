package com.afip.person.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afip.person.models.PersonModel;
import com.afip.person.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public ArrayList<PersonModel> getPersons() {
		return (ArrayList<PersonModel>) personRepository.findAll();
	}

	public PersonModel postPerson(PersonModel person) {
		return personRepository.save(person);
	}

	public Optional<PersonModel> getForId(Long id) {
		return personRepository.findById(id);
	}

	public ArrayList<PersonModel> getForCuil(String cuil) {
		return personRepository.findByCuil(cuil);
	}

	public boolean deletePerson(Long id) {

		try {
			personRepository.deleteById(id);
			return true;
		}

		catch (Exception e) {
			return false;
		}

	}
}