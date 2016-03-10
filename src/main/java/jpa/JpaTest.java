package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.*;
import services.*;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		String s = "SELECT e FROM Person as e";
		try {

			
			HomeService hs = new HomeServiceImpl();
			PersonService ps = new PersonServiceImpl();
			//p.addPerson("toto", "dupont", "toto@gmail.fr");
			Collection<Person> pers = ps.getByName("toto");
			/*for(Person p2 : pers){
				System.out.println(p2);
			}*/
			
			Person p = new Person("jacques", "durand", "ii@ii.fr");

			Person p2 = new Person("jacques2", "durand", "ii@ii.fr");
			List<Person> plist = new ArrayList<Person>();
			plist.add(p);
			plist.add(p2);
			Collection<Home> h = hs.getHomes();
			for (Home home : h){
				hs.setPerson(home, pers);
			}
			/*Person p = new Person();
			p.setFirstName("martin");
			manager.persist(p);

			Person p2 = new Person();
			p2.setFirstName("paul");
			manager.persist(p2);
	
			
			
			Home h = new Home();
			
			Query q = manager.createQuery(s,Person.class);
			//q.setParameter("name", "martin"); 
			List<Person> res = q.getResultList();
			h.setPersons(res);
			manager.persist(h);
			Heater e = new Heater();
			e.setMarque("test");
			e.setHome(h);
			manager.persist(e);
			
		
			*/
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		Query q = manager.createQuery(s,Person.class);
		//q.setParameter("name", "martin"); 
		List<Person> res = q.getResultList();
		
		
		
		System.err.println(res.size());
		System.err.println(res.get(0).getFirstName());
		
		manager.close();
		factory.close();
	}

}
