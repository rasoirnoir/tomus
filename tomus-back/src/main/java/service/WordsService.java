package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class WordsService {

    private String[] words;

    public WordsService(String fileName) throws IOException {
        var fileReader = new FileReader(fileName);
        var br = new BufferedReader(fileReader);

        int character;
        StringBuilder sb = new StringBuilder();
        String fileContent = "";
        while ((character = br.read()) != -1) {
            sb.append((char) character);
        }
        br.close();
        fileReader.close();

        fileContent = sb.toString();
        this.words = fileContent.split(" ");
    }

    public String[] getWords() {
        return this.words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    /**
     * get a random word from the words list
     * 
     * @return A 5 letters word
     */
    public String random() {
        double rndNumber = Math.floor(Math.random() * this.words.length);
        return this.words[(int) rndNumber];
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (String mot : this.words) {
            sb.append(mot + "\n");
        }
        return sb.toString();
    }
}
