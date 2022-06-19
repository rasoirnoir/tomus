package service;

import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * cette interface décrit un client REST qui enverra des requêtes
 * vers un autre microservice.
 * Elle nécéssite d'être configurée dans application.properties pour définir
 * l'url de l'api cible
 * Ici, les @Path définissent la route de la ressource de destination
 */
@Path("/words")
@RegisterRestClient(configKey = "words-api")
public interface WordService {

    @GET
    @Path("/{nbOfLetters}/rnd")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRandomWord(@PathParam("nbOfLetters") int nbOfLetters);
}
