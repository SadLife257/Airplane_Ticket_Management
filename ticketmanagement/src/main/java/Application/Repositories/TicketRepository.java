package Application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
