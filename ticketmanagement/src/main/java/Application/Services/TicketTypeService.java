package Application.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Application.Models.TicketType;
import Application.Repositories.TicketTypeRepository;

@Service
@Transactional
public class TicketTypeService {
	@Autowired
	private TicketTypeRepository repo;
	
	public List<TicketType> listAll() {
        return repo.findAll();
    }
     
    public void save(TicketType ticketType) {
        repo.save(ticketType);
    }
     
    public TicketType get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
}
