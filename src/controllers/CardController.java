package controllers;

import models.Card;
import models.enums.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardController {


    private static CardController instance;

    public CardController() {
    }
    public static CardController getInstance() {
        if (instance == null) {
            instance = new CardController();
        }
        return instance;
    }

    public List<Card> generateCards(List<String> randomWords) {
        List<Card> cards = new ArrayList<>();
        List<Color> colorPalette = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            colorPalette.add(Color.RED);
        }
        for (int i = 0; i < 8; i++) {
            colorPalette.add(Color.BLUE);
        }
        for (int i = 0; i < 7; i++) {
            colorPalette.add(Color.NEUTRAL);
        }
        colorPalette.add(Color.ASSASSIN);

        Collections.shuffle(colorPalette);

        for (String word : randomWords) {
            Color color = colorPalette.removeFirst();
            Card card = new Card(word, color);
            cards.add(card);
        }
        return cards;
    }

    public List<String> generateRandomWords() {
        Set<String> randomWords = new HashSet<>();
        List<String> wordList = loadWords("src/words.txt");

        Random rand = new Random();
        while (randomWords.size() < 25) {
            int index = rand.nextInt(wordList.size());
            randomWords.add(wordList.get(index));
        }
        return new ArrayList<>(randomWords);
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
