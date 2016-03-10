package services;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Person;

public class PersonServiceImpl implements PersonService {

	public Collection<Person> getPerson() {
		String s = "SELECT e FROM Person as e";
		Query q = EntityManagerHelp.getManager().createQuery(s,Person.class);
		
		return q.getResultList();
		
	}

	public void addPerson(String firstName, String lastName, String mail) {
		Person p = new Person(firstName, lastName, mail);
		
		EntityTransaction t = EntityManagerHelp.getManager().getTransaction();
		t.begin();
		
		EntityManagerHelp.getManager().persist(p);
		t.commit();
		EntityManagerHelp.closeEntityManager();;
	}

	public Collection<Person> getByName(String firstName) {
		String s = "SELECT e FROM Person as e WHERE firstName=:name";
		Query q = EntityManagerHelp.getManager().createQuery(s,Person.class);
		q.setParameter("name", firstName);
		return q.getResultList();
		
	}
	
	public void deleteById(int id){
		EntityTransaction t = EntityManagerHelp.getManager().getTransaction();
		t.begin();
		EntityManagerHelp.getManager().remove(EntityManagerHelp.getManager().find(Person.class, new Long(id)));
		t.commit();
		EntityManagerHelp.closeEntityManager();;

	}

}
