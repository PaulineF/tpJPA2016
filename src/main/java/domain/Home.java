package domain;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@XmlRootElement
public class Home {
	private long id;	
	private int size;
	private int numberOfRoom;
	private Collection<Heater> heaters = new ArrayList<Heater>();
	private Collection<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();
	private Collection<Person> persons = new ArrayList<Person>();
	
	
	public Home(){
		
	}
	
	public Home(int size, int numberOfRoom) {
		super();
		this.size = size;
		this.numberOfRoom = numberOfRoom;
	}

	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getNumberOfRoom() {
		return numberOfRoom;
	}
	
	public void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}
	
	@OneToMany(mappedBy="home", cascade = CascadeType.PERSIST)
	public Collection<Heater> getHeaters() {
		return heaters;
	}
	
	public void setHeaters(Collection<Heater> heaters) {
		this.heaters = heaters;
	}
	
	@OneToMany(mappedBy="home")
	@JsonIgnore
	public Collection<ElectronicDevice> getElectronicDevices() {
		return electronicDevices;
	}
	
	public void setElectronicDevices(Collection<ElectronicDevice> electronicDevices) {
		this.electronicDevices = electronicDevices;
	}

	@ManyToMany
	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	
	
	
	public String toString(){
		return "Home : "+ size;
	}

}
