package com.afip.person.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.afip.person.models.PersonModel;

public interface PersonRepository extends CrudRepository<PersonModel, Long> {
	public abstract ArrayList<PersonModel> findByCuil(String cuil);

	public abstract ArrayList<PersonModel> findByDni(String dni);
}