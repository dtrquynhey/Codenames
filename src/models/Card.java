package models;

import models.enums.CardType;

public class Card {

    private int cardId;
    private int gameId;
    private String word;
    private CardType type;
    private Boolean isGuessed;


    public Card() {
    }

    public Card(int cardId, int gameId, String word, CardType type, Boolean isGuessed) {
        this.cardId = cardId;
        this.gameId = gameId;
        this.word = word;
        this.type = type;
        this.isGuessed = isGuessed;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Boolean getGuessed() {
        return isGuessed;
    }

    public void setGuessed(Boolean guessed) {
        isGuessed = guessed;
    }


    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", gameId=" + gameId +
                ", word='" + word + '\'' +
                ", type=" + type +
                ", isGuessed=" + isGuessed +
                '}';
    }
}
