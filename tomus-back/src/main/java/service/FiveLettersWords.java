package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FiveLettersWords {

    private String[] words;

    public FiveLettersWords() throws IOException {
        System.out.println("Construction de la liste des mots de 5 lettres.");
        var fileReader = new FileReader("cinq.txt");
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

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (String mot : this.words) {
            sb.append(mot + "\n");
        }
        return sb.toString();
    }
}
