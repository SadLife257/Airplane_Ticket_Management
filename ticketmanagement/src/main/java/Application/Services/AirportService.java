package Application.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Application.Models.Airport;
import Application.Repositories.AirportRepository;

@Service
@Transactional
public class AirportService {
	@Autowired
	private AirportRepository repo;
	
	public List<Airport> listAll() {
        return repo.findAll();
    }
     
    public void save(Airport airport) {
        repo.save(airport);
    }
     
    public Airport get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
}
