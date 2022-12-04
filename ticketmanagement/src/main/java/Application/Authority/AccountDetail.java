package Application.Authority;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Application.Models.Account;
import io.jsonwebtoken.Claims;

public class AccountDetail implements UserDetails{

	private static final long serialVersionUID = 1L;
	private Account account;
    
    public AccountDetail(Account account) {
        this.account = account;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(account.getAccountRole());
        return Arrays.asList(authority);
	}
	
	public String getId() {
		return account.getAccountID();
	}
	
	public String getEmail() {
		return account.getAccountEmail();
	}
	
	public String getRole()
	{
		return account.getAccountRole();
	}


	@Override
	public String getPassword() {
		return account.getAccountPassword();
	}

	@Override
	public String getUsername() {
		return account.getAccountUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
