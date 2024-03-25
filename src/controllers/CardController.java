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

        // Populate the color palette with the colors required for the game
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

        // Shuffle the color palette
        Collections.shuffle(colorPalette);

        // Assign colors to the cards
        for (String word : randomWords) {
            // Pop the first color from the shuffled color palette
            Color color = colorPalette.remove(0);

            // Create the card with the assigned color
            Card card = new Card(word, color, false);

            // Handle exceptions if necessary
            try {
                cardRepository.createCard(card);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // Add the card to the list of cards
            cards.add(card);
        }

        return cards;
    }

}
