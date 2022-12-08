package Application.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Application.Models.*;
import Application.Repositories.*;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	public static Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	private AirportRepository airportService;
	
	@Autowired
	private CustomerRepository customerService;
	
	@Autowired
	private FlightRepository flightService;
	
	@Autowired
	private TicketRepository ticketService;
	
	@Autowired
	private TicketTypeRepository ticketTypeService;

//--------------------Main Page--------------------
//--------------------Main Page--------------------
	
//--------------------Airport Service--------------------
	@RequestMapping(value="/airport/", method = RequestMethod.GET)
	public ResponseEntity<List<Airport>> listAllAirport(){
		List<Airport> listAirports = airportService.findAll();
		
		if(listAirports.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Airport>>(listAirports, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/airport/{Airport_ID}", method = RequestMethod.GET)
	public Airport findAirport(@PathVariable(value = "Airport_ID") String airportID) {
		Airport airport = airportService.getOne(airportID);
		if(airport == null) {
			ResponseEntity.notFound().build();
		}
		return airport;
	}
	
	@RequestMapping(value = "/airport/", method = RequestMethod.POST)
	public Airport saveAirport(@Valid @RequestBody Airport airport) {
		return airportService.save(airport);
	}
	
	@RequestMapping(value = "/airport/{Airport_ID}", method = RequestMethod.PUT)
	public ResponseEntity<Airport> updateAirport(@PathVariable(value = "Airport_ID") String airportID,
													@Valid @RequestBody Airport airportForm) {
		Airport airport = airportService.getOne(airportID);
	    if(airport == null) {
	        return ResponseEntity.notFound().build();
	    }
	    airport.setAirportName(airportForm.getAirportName());
	    airport.setAirportLocation(airportForm.getAirportLocation());

	    Airport updatedAirport = airportService.save(airport);
	    return ResponseEntity.ok(updatedAirport);
	}
	
	@RequestMapping(value = "/airport/{Airport_ID}", method = RequestMethod.DELETE)
	public ResponseEntity<Airport> deleteAirport(@PathVariable(value = "Airport_ID") String airportID) {
		Airport airport = airportService.getOne(airportID);
	    if(airport == null) {
	        return ResponseEntity.notFound().build();
	    }

	    airportService.delete(airport);
	    return ResponseEntity.ok().build();
	}
//--------------------Airport Service--------------------
	
//--------------------Customer Service--------------------
	@RequestMapping(value="/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomer(){
		List<Customer> listCustomers = customerService.findAll();
		
		if(listCustomers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Customer>>(listCustomers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/{Customer_ID}", method = RequestMethod.GET)
	public Customer findCustomer(@PathVariable(value = "Customer_ID") String customerID) {
		Customer customer = customerService.getOne(customerID);
		if(customer == null) {
			ResponseEntity.notFound().build();
		}
		return customer;
	}
	
	@RequestMapping(value = "/customer/", method = RequestMethod.POST)
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@RequestMapping(value = "/customer/{Customer_ID}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "Customer_ID") String customerID,
													@Valid @RequestBody Customer customerForm) {
		Customer customer = customerService.getOne(customerID);
	    if(customer == null) {
	        return ResponseEntity.notFound().build();
	    }
	    customer.setCustomerName(customerForm.getCustomerName());
	    customer.setCustomerCMND(customerForm.getCustomerCMND());
	    customer.setCustomerPhone(customerForm.getCustomerPhone());

	    Customer updatedCustomer = customerService.save(customer);
	    return ResponseEntity.ok(updatedCustomer);
	}
	
	@RequestMapping(value = "/customer/{Customer_ID}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "Customer_ID") String customerID) {
		Customer customer = customerService.getOne(customerID);
	    if(customer == null) {
	        return ResponseEntity.notFound().build();
	    }

	    customerService.delete(customer);
	    return ResponseEntity.ok().build();
	}
//--------------------Customer Service--------------------
	
//--------------------Flight Service--------------------
	@RequestMapping(value="/flight/", method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> listAllFlight(){
		List<Flight> listFlights = flightService.findAll();
		
		if(listFlights.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Flight>>(listFlights, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/flight/{Flight_ID}", method = RequestMethod.GET)
	public Flight findFlight(@PathVariable(value = "Flight_ID") String flightID) {
		Flight flight = flightService.getOne(flightID);
		if(flight == null) {
			ResponseEntity.notFound().build();
		}
		return flight;
	}
	
	@RequestMapping(value = "/flight/", method = RequestMethod.POST)
	public Flight saveFlight(@Valid @RequestBody Flight flight) {
		Airport departureAirport = airportService.getOne(flight.getDepartureAirport().getAirportID());
		Airport arriveAirport = airportService.getOne(flight.getArriveAirport().getAirportID());
		
		flight.setDepartureAirport(departureAirport);
		flight.setArriveAirport(arriveAirport);
		
		return flightService.save(flight);
	}
	
	@RequestMapping(value = "/flight/{Flight_ID}", method = RequestMethod.PUT)
	public ResponseEntity<Flight> updateFlight(@PathVariable(value = "Flight_ID") String flightID,
													@Valid @RequestBody Flight flightForm) {
		Flight flight = flightService.getOne(flightID);
	    if(flight == null) {
	        return ResponseEntity.notFound().build();
	    }
	    flight.setNumberOfSeat(flightForm.getNumberOfSeat());
	    flight.setDepartureTime(flightForm.getDepartureTime());
	    flight.setDepartureDate(flightForm.getDepartureDate());
	    
	    Airport departureAirport = airportService.getOne(flightForm.getDepartureAirport().getAirportID());
		Airport arriveAirport = airportService.getOne(flightForm.getArriveAirport().getAirportID());
		
		flight.setDepartureAirport(departureAirport);
		flight.setArriveAirport(arriveAirport);
		
	    Flight updatedFlight = flightService.save(flight);
	    return ResponseEntity.ok(updatedFlight);
	}
	
	@RequestMapping(value = "/flight/{Flight_ID}", method = RequestMethod.DELETE)
	public ResponseEntity<Flight> deleteFlight(@PathVariable(value = "Flight_ID") String flightID) {
		Flight flight = flightService.getOne(flightID);
	    if(flight == null) {
	        return ResponseEntity.notFound().build();
	    }

	    flightService.delete(flight);
	    return ResponseEntity.ok().build();
	}
//--------------------Flight Service--------------------

//--------------------Ticket Type Service--------------------
	@RequestMapping(value="/ticket_type/", method = RequestMethod.GET)
	public ResponseEntity<List<TicketType>> listAllTicketType(){
		List<TicketType> listTicketTypes = ticketTypeService.findAll();
		
		if(listTicketTypes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<TicketType>>(listTicketTypes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ticket_type/{Ticket_Type_ID}", method = RequestMethod.GET)
	public TicketType findTicketType(@PathVariable(value = "Ticket_Type_ID") String ticketTypeID) {
		TicketType ticketType = ticketTypeService.getOne(ticketTypeID);
		if(ticketType == null) {
			ResponseEntity.notFound().build();
		}
		return ticketType;
	}
	
	@RequestMapping(value = "/ticket_type/", method = RequestMethod.POST)
	public TicketType saveTicketType(@Valid @RequestBody TicketType ticketType) {
		return ticketTypeService.save(ticketType);
	}
	
	@RequestMapping(value = "/ticket_type/{Ticket_Type_ID}", method = RequestMethod.PUT)
	public ResponseEntity<TicketType> updateTicketType(@PathVariable(value = "Ticket_Type_ID") String ticketTypeID,
													@Valid @RequestBody TicketType ticketTypeForm) {
		TicketType ticketType = ticketTypeService.getOne(ticketTypeID);
	    if(ticketType == null) {
	        return ResponseEntity.notFound().build();
	    }
	    ticketType.setTicketTypeName(ticketTypeForm.getTicketTypeName());
	    ticketType.setTicketTypePrice(ticketTypeForm.getTicketTypePrice());
	    ticketType.setServiceFee(ticketTypeForm.getServiceFee());
	    TicketType updatedTicketType = ticketTypeService.save(ticketType);
	    return ResponseEntity.ok(updatedTicketType);
	}
	
	@RequestMapping(value = "/ticket_type/{Ticket_Type_ID}", method = RequestMethod.DELETE)
	public ResponseEntity<TicketType> deleteTicketType(@PathVariable(value = "Ticket_Type_ID") String ticketTypeID) {
		TicketType ticketType = ticketTypeService.getOne(ticketTypeID);
	    if(ticketType == null) {
	        return ResponseEntity.notFound().build();
	    }

	    ticketTypeService.delete(ticketType);
	    return ResponseEntity.ok().build();
	}
//--------------------Ticket Type Service--------------------

//--------------------Ticket Service--------------------
	@RequestMapping(value="/ticket/", method = RequestMethod.GET)
	public ResponseEntity<List<Ticket>> listAllTicket(){
		List<Ticket> listTickets = ticketService.findAll();
		
		if(listTickets.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Ticket>>(listTickets, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ticket/{Ticket_Number}", method = RequestMethod.GET)
	public Ticket findTicket(@PathVariable(value = "Ticket_Number") String ticketID) {
		Ticket ticket = ticketService.getOne(ticketID);
		if(ticket == null) {
			ResponseEntity.notFound().build();
		}
		return ticket;
	}
	
	@RequestMapping(value = "/ticket/", method = RequestMethod.POST)
	public Ticket saveTicket(@Valid @RequestBody Ticket ticket) {
		Customer customer = customerService.getOne(ticket.getCustomer().getCustomerID());
		Flight flight = flightService.getOne(ticket.getFlight().getFlightID());
		TicketType ticketType = ticketTypeService.getOne(ticket.getTicketType().getTicketTypeID());
		
		ticket.setCustomer(customer);
		ticket.setFlight(flight);
		ticket.setTicketType(ticketType);
		
		return ticketService.save(ticket);
	}
	
	@RequestMapping(value = "/ticket/{Ticket_Number}", method = RequestMethod.PUT)
	public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "Ticket_Number") String ticketID,
													@Valid @RequestBody Ticket ticketForm) {
		Ticket ticket = ticketService.getOne(ticketID);
	    if(ticket == null) {
	        return ResponseEntity.notFound().build();
	    }
	    ticket.setBookingDate(ticketForm.getBookingDate());
	    ticket.setReceiptDate(ticketForm.getReceiptDate());
	    Customer customer = customerService.getOne(ticketForm.getCustomer().getCustomerID());
		Flight flight = flightService.getOne(ticketForm.getFlight().getFlightID());
		TicketType ticketType = ticketTypeService.getOne(ticketForm.getTicketType().getTicketTypeID());
		
		ticket.setCustomer(customer);
		ticket.setFlight(flight);
		ticket.setTicketType(ticketType);
	    Ticket updatedTicket = ticketService.save(ticket);
	    return ResponseEntity.ok(updatedTicket);
	}
	
	@RequestMapping(value = "/ticket/{Ticket_Number}", method = RequestMethod.DELETE)
	public ResponseEntity<TicketType> deleteTicket(@PathVariable(value = "Ticket_Number") String ticketID) {
		Ticket ticket = ticketService.getOne(ticketID);
	    if(ticket == null) {
	        return ResponseEntity.notFound().build();
	    }

	    ticketService.delete(ticket);
	    return ResponseEntity.ok().build();
	}
//--------------------Ticket Service--------------------
}
