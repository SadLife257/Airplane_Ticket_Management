package Application.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable{
	private String customerID;
	private String customerName;
	private String customerCMND;
	private String customerPhone;
	
	public Customer()
	{
		
	}

	@Id
	@GeneratedValue(generator = "Customer_ID_Generator")  
    @GenericGenerator(name = "Customer_ID_Generator", 
    				  strategy = "Application.ID_Generators.Customer_ID_Generator")
	@Column(name = "Customer_ID")
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	@Column(name = "Customer_Name")
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "Customer_CMND")
	public String getCustomerCMND() {
		return customerCMND;
	}

	public void setCustomerCMND(String customerCMND) {
		this.customerCMND = customerCMND;
	}

	@Column(name = "Customer_Phone")
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}	
}
