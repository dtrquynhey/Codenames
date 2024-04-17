package controllers;

import contracts.ICardContract;
import models.Card;
import models.enums.Color;
import repositories.CardRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardController implements ICardContract {


    private static CardController instance;
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    public static CardController getInstance(CardRepository cardRepository) {
        if (instance == null) {
            instance = new CardController(cardRepository);
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

//            try {
//                cardRepository.createCard(new Card(word));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

            cards.add(card);
        }
        return cards;
    }

}
