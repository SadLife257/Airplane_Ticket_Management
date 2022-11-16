package Application.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="account")
public class Account {
	private String accountID;
	private String accountUsername;
	private String accountEmail;
	private String accountPassword;
	private String accountRole;
	
	public Account()
	{
		
	}

	@Id
	@GeneratedValue(generator = "Account_ID_Generator")  
    @GenericGenerator(name = "Account_ID_Generator", 
    				  strategy = "Application.ID_Generators.Account_ID_Generator")
	@Column(name = "Account_ID")
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	@Column(name = "Account_Username")
	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	@Column(name = "Account_Email")
	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	@Column(name = "Account_Password")
	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	@Column(name = "Account_Role")
	public String getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(String accountRole) {
		this.accountRole = accountRole;
	}
	
	
}
