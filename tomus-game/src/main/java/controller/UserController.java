package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import entity.User;

@Path("/user")
public class UserController {

    @GET
    @Path("/all")
    public Response getAllUsers() {
        return Response.ok(User.findAll()).build();
    }
}
