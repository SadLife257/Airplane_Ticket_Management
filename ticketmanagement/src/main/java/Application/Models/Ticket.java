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
@Table(name="ticket")
public class Ticket {
	private String ticketNumber;
	private Calendar bookingDate;
	private Calendar receiptDate;
	private String customerID;
	private String ticketTypeID;
	private String flightID;
	
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

	public Calendar getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Calendar bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Calendar getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Calendar receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getTicketTypeID() {
		return ticketTypeID;
	}

	public void setTicketTypeID(String ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
}
