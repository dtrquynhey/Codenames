package models;
import models.enums.Color;

public class Card {
    private String word;
    private Boolean isRevealed;
    private Color color;

    public Card() {
    }

    public Card(String word, Boolean isRevealed, Color color) {
        this.word = word;
        this.isRevealed = isRevealed;
        this.color = color;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Boolean getRevealed() {
        return isRevealed;
    }

    public void setRevealed(Boolean revealed) {
        isRevealed = revealed;
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
