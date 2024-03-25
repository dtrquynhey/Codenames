package models;
import models.enums.Color;

public class Card {

    private int cardId;
    private String word;
    private Color color;
    private Boolean isRevealed;

    public Card() {
    }

    public Card(String word, Color color, Boolean isRevealed) {
        this.word = word;
        this.color = color;
        this.isRevealed = isRevealed;
    }



    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Boolean getIsRevealed() {
        return isRevealed;
    }

    public void setIsRevealed(Boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Card{" +
                "word='" + word + '\'' +
                ", isRevealed=" + isRevealed +
                ", color=" + color +
                '}';
    }
}
