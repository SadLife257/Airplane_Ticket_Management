package Application.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Application.Models.Ticket;
import Application.Repositories.TicketRepository;

@Service
@Transactional
public class TicketService {
	@Autowired
	private TicketRepository repo;
	
	public List<Ticket> listAll() {
        return repo.findAll();
    }
     
    public void save(Ticket ticket) {
        repo.save(ticket);
    }
     
    public Ticket get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
}
