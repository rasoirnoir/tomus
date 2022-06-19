package service;

import javax.inject.Singleton;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.Blocking;

@Singleton
public class StateService {

    @RestClient
    WordService wordService;

    @Blocking
    public String getRandomWord(int nbOfLetters) {
        return wordService.getRandomWord(nbOfLetters);
    }
}
