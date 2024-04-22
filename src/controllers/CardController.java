package controllers;

import contracts.ICardContract;
import models.Card;
import models.enums.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardController implements ICardContract {


    private static CardController instance;

    public CardController() {
    }
    public static CardController getInstance() {
        if (instance == null) {
            instance = new CardController();
        }
        return instance;
    }
    @Override
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
            Card card = new Card(word, color, false);
            cards.add(card);
        }
        return cards;
    }

}
