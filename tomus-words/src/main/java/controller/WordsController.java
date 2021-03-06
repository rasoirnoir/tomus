package controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import service.FiveLettersWordsService;
import service.SevenLettersWordsService;
import service.SixLettersWordsService;

@Path("/words")
public class WordsController {

    @Inject
    protected FiveLettersWordsService fiveLettersWords;

    @Inject
    protected SixLettersWordsService sixLettersWords;

    @Inject
    protected SevenLettersWordsService sevenLettersWords;

    private static final Logger LOG = Logger.getLogger(WordsController.class);

    @GET
    @Path("{numberOfLetters}/all")
    public Response getAll(@PathParam("numberOfLetters") int letters) {
        LOG.info(String.format("All %s letters words requested", letters));
        switch (letters) {
            case 5:
                return Response.ok(this.fiveLettersWords.getWords()).build();
            case 6:
                return Response.ok(this.sixLettersWords.getWords()).build();
            case 7:
                return Response.ok(this.sevenLettersWords.getWords()).build();
            default:
                return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("{numberOfLetters}/rnd")
    public Response getOneRandom(@PathParam("numberOfLetters") int letters) {
        LOG.info(String.format("Random %s letter word requested", letters));
        switch (letters) {
            case 5:
                return Response.ok(this.fiveLettersWords.random()).build();
            case 6:
                return Response.ok(this.sixLettersWords.random()).build();
            case 7:
                return Response.ok(this.sevenLettersWords.random()).build();
            default:
                return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
