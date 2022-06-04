package controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import service.FiveLettersWords;

@Path("/words")
public class WordsController {

    @Inject
    private FiveLettersWords fiveLettersWords;

    @GET
    @Path("{numberOfLetters}/all")
    public Response getAll(@PathParam("numberOfLetters") int letters) {
        switch (letters) {
            case 5:
                return Response.ok(this.fiveLettersWords.getWords()).build();
            default:
                return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("{numberOfLetters}/rnd")
    public Response getOneRandom(@PathParam("numberOfLetters") int letters) {
        switch (letters) {
            case 5:
                return Response.ok(this.fiveLettersWords.random()).build();
            default:
                return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
