package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import model.Chatroom;
import service.ChatService;

import java.util.UUID;

@Path("/api/chat")
public class ChatController {

    @Inject
    ChatService chatService;

    @POST
    @Path("/create")
    public Response createChatroom(@QueryParam("flightLogId") UUID flightLogId, @QueryParam("status") String status) {
        Chatroom chatroom = chatService.createChatroom(flightLogId, status);
        return Response.ok(chatroom).build();
    }
}