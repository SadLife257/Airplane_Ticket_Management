package Application.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="ticket")
public class Ticket implements Serializable{
	private String ticketNumber;
	private Calendar bookingDate;
	private Calendar receiptDate;
	
	
	private Customer customer;
	
	
	private TicketType ticketType;
	
	
	private Flight flight;
	
	public Ticket()
	{
		
	}

	@Id
	@GeneratedValue(generator = "Ticket_ID_Generator")  
    @GenericGenerator(name = "Ticket_ID_Generator", 
    				  strategy = "Application.ID_Generators.Ticket_ID_Generator")
	@Column(name = "Ticket_Number")
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	public Calendar getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Calendar bookingDate) {
		this.bookingDate = bookingDate;
	}

	@JsonFormat(pattern="dd/MM/yyyy")
	public Calendar getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Calendar receiptDate) {
		this.receiptDate = receiptDate;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "Customer_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "TicketType_ID")
	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "Flight_ID")
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
