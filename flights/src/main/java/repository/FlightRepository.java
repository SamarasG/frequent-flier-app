package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import models.Flight;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class FlightRepository implements PanacheRepository<Flight> {

    public List<Flight> findByUserId(UUID userId) {
        return list("userId", userId);
    }
}