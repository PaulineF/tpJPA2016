package domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private String mail;
	private Collection<Home> homes = new ArrayList<Home>();

	public Person() {	}
	public Person(String firstName, String lastName, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
	}
	
	@Id
    	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@ManyToMany(mappedBy="persons")
	public Collection<Home> getHomes() {
		return homes;
	}
	public void setHomes(Collection<Home> homes) {
		this.homes = homes;
	}
	public String toString(){
		return firstName + " " + lastName + " : " +mail;
	}
}
