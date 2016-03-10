package services;

import java.util.Collection;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Home;
import domain.Person;

public class HomeServiceImpl implements HomeService {

	public Collection<Home> getHomes() {
		String s = "SELECT e FROM Home as e";
		Query q = EntityManagerHelp.getManager().createQuery(s,Home.class);

		return q.getResultList();
	}

	public void addHome(int nbroom, int size) {
		Home p = new Home(size, nbroom);

		EntityTransaction t = EntityManagerHelp.getManager().getTransaction();
		t.begin();

		EntityManagerHelp.getManager().persist(p);
		t.commit();

	}

	public void setPerson(Home home, Collection<Person> pers) {
		EntityTransaction t = EntityManagerHelp.getManager().getTransaction();
		t.begin();

		home.setPersons(pers);
		EntityManagerHelp.getManager().persist(home);
		t.commit();

	}

}
