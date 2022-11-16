package Application.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Application.Models.Account;

public interface AccountRepository extends CrudRepository<Account, String>{
	@Query("SELECT a FROM Account a WHERE a.accountUsername = :accountUsername")
    public Account getUserByUsername(@Param("accountUsername") String accountUsername);
}
