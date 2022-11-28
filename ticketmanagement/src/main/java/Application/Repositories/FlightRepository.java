package Application.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Application.Models.Flight;
import Application.Models.Airport;

public interface FlightRepository extends JpaRepository<Flight, String> {
//	@Query("SELECT f FROM flight f WHERE f.Flight_ID LIKE %?1%")
//	public List<Airport> search(String keyword);
}
