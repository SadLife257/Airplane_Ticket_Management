package Application.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Models.Airport;

public interface AirportRepository extends JpaRepository<Airport, String>{

}
