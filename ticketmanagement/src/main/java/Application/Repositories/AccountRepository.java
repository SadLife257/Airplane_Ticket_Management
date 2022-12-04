package Application.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Application.Models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	Optional<Account> findByAccountUsername(String accountUsername);
	
	Boolean existsByAccountUsername(String accountUsername);

	Boolean existsByAccountEmail(String accountEmail);
}
