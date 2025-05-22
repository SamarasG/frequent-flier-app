package controllers;

import models.Flight;
import service.FlightService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightController {

    @Inject
    FlightService flightService;

    @GET
    @Path("/user/{userId}")
    public List<Flight> getUserFlightLogs(@PathParam("userId") UUID userId) {
        return flightService.getUserFlightLogs(userId);
    }
    @GET
    @Path("/user/{userId}/sorted")
    public List<Flight> getUserFlightsSorted(@PathParam("userId") UUID userId) {
        return flightService.getUserFlightsSorted(userId);
    }

    @POST
    @Path("/validate")
    public Response validateAndCreateFlightLog(@QueryParam("userId") UUID userId, @QueryParam("flightNumber") String flightNumber) {
        Optional<Flight> flight = flightService.validateAndCreateFlightLog(userId, flightNumber);
        if (flight.isPresent()) {
            return Response.ok(flight.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Flight number not found in mock database").build();
    }
}