package services;

import java.util.Collection;

import domain.Person;

public interface PersonService {
	Collection<Person> getPerson();
	void addPerson(String firstName, String lastName, String mail);
	
	Collection<Person> getByName(String firstName);
	void deleteById(int id);
	
}
