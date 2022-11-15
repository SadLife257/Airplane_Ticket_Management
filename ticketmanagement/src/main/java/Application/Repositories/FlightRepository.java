package Application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Models.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
