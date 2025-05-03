package service;

import models.Flight;
import repository.FlightRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class FlightService {

    @Inject
    FlightRepository flightRepository;

    private static final String MOCK_DB_URL = "jdbc:postgresql://localhost:5432/mockdb";
    private static final String MOCK_DB_USER = "admin";
    private static final String MOCK_DB_PASSWORD = "admin";

    public List<Flight> getUserFlightLogs(UUID userId) {
        return flightRepository.findByUserId(userId);
    }

    public Optional<Flight> validateAndCreateFlightLog(UUID userId, String flightNumber) {
        try (Connection connection = DriverManager.getConnection(MOCK_DB_URL, MOCK_DB_USER, MOCK_DB_PASSWORD)) {
            String query = "SELECT * FROM mock_flights WHERE flight_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, flightNumber);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setUserId(userId);
                    flight.setFlightNumber(flightNumber);
                    flight.setDepartureAirport(resultSet.getString("departure_airport"));
                    flight.setArrivalAirport(resultSet.getString("arrival_airport"));
                    flight.setDepartureTime(resultSet.getTimestamp("scheduled_departure_time").toLocalDateTime());
                    flight.setArrivalTime(resultSet.getTimestamp("scheduled_arrival_time").toLocalDateTime());
                    flightRepository.persist(flight);
                    return Optional.of(flight);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}