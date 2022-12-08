package Application.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="flight")
public class Flight implements Serializable{
	private String flightID;
	private int numberOfSeat;
	private Calendar departureTime;
	private Calendar departureDate;
	private Airport departureAirport;
	private Airport arriveAirport;
	
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

	@Column(name = "Departure_Time")
	@JsonFormat(pattern="HH:mm")
	public Calendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name = "Departure_Date")
	@JsonFormat(pattern="dd/MM/yyyy")
	public Calendar getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Calendar departureDate) {
		this.departureDate = departureDate;
	}

  	@ManyToOne(fetch = FetchType.LAZY, optional = false)
  	@JoinColumn(name = "FK_Airport_ID_1", nullable = false)
	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
  	@JoinColumn(name = "FK_Airport_ID_2", nullable = false)
	public Airport getArriveAirport() {
		return arriveAirport;
	}

	public void setArriveAirport(Airport arriveAirport) {
		this.arriveAirport = arriveAirport;
	}

	
}
