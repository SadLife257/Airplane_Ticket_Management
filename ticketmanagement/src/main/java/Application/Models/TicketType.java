package Application.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ticket_type")
public class TicketType {
	private String ticketTypeID;
	private String ticketTypeName;
	private int ticketTypePrice;
	private int serviceFee;
	
	public TicketType()
	{
		
	}

	@Id
	@GeneratedValue(generator = "TicketType_ID_Generator")  
    @GenericGenerator(name = "TicketType_ID_Generator", 
    				  strategy = "Application.ID_Generators.TicketType_ID_Generator")
	@Column(name = "Ticket_Type_ID")
	public String getTicketTypeID() {
		return ticketTypeID;
	}

	public void setTicketTypeID(String ticketTypeID) {
		this.ticketTypeID = ticketTypeID;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public int getTicketTypePrice() {
		return ticketTypePrice;
	}

	public void setTicketTypePrice(int ticketTypePrice) {
		this.ticketTypePrice = ticketTypePrice;
	}

	public int getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}
}
