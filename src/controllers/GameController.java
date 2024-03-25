package controllers;

import contracts.IGameContract;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController implements IGameContract {
    @Override
    public List<String> generateRandomWords() {
        List<String> randomWords = new ArrayList<>();
        List<String> wordList = loadWords("src/words.txt");

        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            int index = rand.nextInt(wordList.size());
            randomWords.add(wordList.get(index));
        }
        return randomWords;
    }

    public static List<String> loadWords(String filename) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
