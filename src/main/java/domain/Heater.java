package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater extends IntelligentDevice{

	private Home home;
	private String marque;
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Heater(){
		
	}
	
	public Heater(String name, Home home) {
		super(name);
		this.home = home;
	}


	

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
	
	
	
}
