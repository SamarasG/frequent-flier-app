package controllers;

import models.User;
import services.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") UUID id) {
        return userService.getUserById(id)
                .map(user -> Response.ok(user).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response createUser(User user) {
        User createdUser = userService.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") UUID id) {
        userService.deleteUser(id);
        return Response.noContent().build();
    }
    @POST
    @Path("/register")
    public Response registerUser(User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return Response.status(Response.Status.CREATED).entity(registeredUser).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    @POST
    @Path("/login")
    public Response loginUser(@QueryParam("email") String email, @QueryParam("password") String password) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            return Response.ok("Login successful").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }
}