package Application.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Application.Models.Flight;
import Application.Repositories.FlightRepository;

@Service
@Transactional
public class FlightService {
	@Autowired
	private FlightRepository repo;
	
	public List<Flight> listAll() {
        return repo.findAll();
    }
     
    public void save(Flight flight) {
        repo.save(flight);
    }
     
    public Flight get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
}
