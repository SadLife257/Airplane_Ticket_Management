package Application.Models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="flight")
public class Flight {
	private String flightID;
	private int numberOfSeat;
	private Calendar departureTime;
	private Calendar departureDate;
	private String departureAirportID;
	private String arriveAirportID;
	
	public Flight()
	{
		
	}

	@Id
	@GeneratedValue(generator = "Flight_ID_Generator")  
    @GenericGenerator(name = "Flight_ID_Generator", 
    				  strategy = "Application.ID_Generators.Flight_ID_Generator")
	@Column(name = "Flight_ID")
	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public Calendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	public Calendar getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Calendar departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureAirportID() {
		return departureAirportID;
	}

	public void setDepartureAirportID(String departureAirportID) {
		this.departureAirportID = departureAirportID;
	}

	public String getArriveAirportID() {
		return arriveAirportID;
	}

	public void setArriveAirportID(String arriveAirportID) {
		this.arriveAirportID = arriveAirportID;
	}	
}
