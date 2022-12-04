package Application.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Application.Authority.AccountDetail;
import Application.Models.Account;
import Application.Repositories.AccountRepository;

@Service
public class AccountDetailService implements UserDetailsService {
 
    @Autowired
    private AccountRepository repo;
     
    @Override
    @Transactional
    public AccountDetail loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Account account = repo.findByAccountUsername(username)
        		.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
         
        return new AccountDetail(account);
    }

}
