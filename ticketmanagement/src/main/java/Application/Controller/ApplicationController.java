package Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Application.Models.Customer;
import Application.Services.CustomerService;

@Controller
public class ApplicationController {
	
//	@Autowired
//	private AirportService airportService; 
	@Autowired
	private CustomerService customerService; 
//	@Autowired
//	private FlightService flightService; 
//	@Autowired
//	private TicketTypeService ticketTypeService; 
//	@Autowired
//	private TicketService ticketService; 
	
//--------------------Main Page--------------------
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
//--------------------Main Page--------------------
	
//--------------------Airport Service--------------------
//--------------------Airport Service--------------------
	
//--------------------Customer Service--------------------
	@RequestMapping("/customer")
	public String viewCustomerPage(Model model) {
		List<Customer> listCustomers = customerService.listAll();
		model.addAttribute("listCustomers", listCustomers);
		
		return "Customer/customer";
	}
	
	@RequestMapping("/new")
	public String showNewCustomerPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "Customer/new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{Customer_ID}")
	public ModelAndView showEditCustomerPage(@PathVariable(name = "Customer_ID") String customerID) {
		ModelAndView mav = new ModelAndView("Customer/edit_customer");
		Customer customer = customerService.get(customerID);
		mav.addObject("customer", customer);
		
		return mav;
	}
	
	@RequestMapping("/delete/{Customer_ID}")
	public String deleteCustomer(@PathVariable(name = "Customer_ID") String customerID) {
		customerService.delete(customerID);
		return "redirect:/";		
	}
//--------------------Customer Service--------------------
	
//--------------------Flight Service--------------------
//--------------------Flight Service--------------------

//--------------------Ticket Type Service--------------------
//--------------------Ticket Type Service--------------------

//--------------------Ticket Service--------------------
//--------------------Ticket Service--------------------
}
