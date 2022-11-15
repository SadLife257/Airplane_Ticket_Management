package Application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Models.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

}
