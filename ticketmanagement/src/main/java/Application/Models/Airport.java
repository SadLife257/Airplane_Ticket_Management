package Application.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="airport")
public class Airport {
	private String airportID;
	private String airportName;
	private String airportLocation;

	public Airport()
	{
		
	}
	
	@Id
	@GeneratedValue(generator = "Airport_ID_Generator")  
    @GenericGenerator(name = "Airport_ID_Generator", 
    				  strategy = "Application.ID_Generators.Airport_ID_Generator")
	@Column(name = "Airport_ID")
	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
}
