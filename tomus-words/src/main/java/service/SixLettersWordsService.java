package service;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SixLettersWordsService extends WordsService {

    public SixLettersWordsService() throws IOException {
        super("six.txt");
    }

}
