package service;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FiveLettersWordsService extends WordsService {

    public FiveLettersWordsService() throws IOException {
        super("cinq.txt");
    }

}
