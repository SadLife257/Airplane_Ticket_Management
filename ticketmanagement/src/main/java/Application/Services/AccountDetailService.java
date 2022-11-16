package Application.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Application.Authority.AccountDetail;
import Application.Models.Account;
import Application.Repositories.AccountRepository;

public class AccountDetailService implements UserDetailsService {
 
    @Autowired
    private AccountRepository repo;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account account = repo.getUserByUsername(username);
         
        if (account == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new AccountDetail(account);
    }

}
