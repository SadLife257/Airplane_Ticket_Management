package Application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
