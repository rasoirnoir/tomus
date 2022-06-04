package service;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SevenLettersWordsService extends WordsService {
    public SevenLettersWordsService() throws IOException {
        super("sept.txt");
    }
}
