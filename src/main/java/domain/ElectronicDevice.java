package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice extends IntelligentDevice {

	private double averageConsommation;
	private Home home;
	
	public ElectronicDevice(){
		
	}
	
	public ElectronicDevice(String name, double averageConsommation, Home home) {
		super(name);
		this.averageConsommation = averageConsommation;
		this.home = home;
	}

	
	
	public double getAverageConsommation() {
		return averageConsommation;
	}
	
	public void setAverageConsommation(double averageConsommation) {
		this.averageConsommation = averageConsommation;
	}

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	
	
	
	
}
