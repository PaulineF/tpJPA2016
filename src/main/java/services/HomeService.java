package services;

import java.util.Collection;

import domain.*;
public interface HomeService {
	Collection<Home> getHomes();
	
	void addHome(int nbroom, int size);
	
	void setPerson(Home home, Collection<Person> pers);
	
}
