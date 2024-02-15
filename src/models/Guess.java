package models;

public class Guess {

    private int guessId;
    private int turnId;
    private int cardId;
    private Boolean isCorrect;


    public Guess() {
    }

    public Guess(int guessId, int turnId, int cardId, Boolean isCorrect) {
        this.guessId = guessId;
        this.turnId = turnId;
        this.cardId = cardId;
        this.isCorrect = isCorrect;
    }


    public int getGuessId() {
        return guessId;
    }

    public void setGuessId(int guessId) {
        this.guessId = guessId;
    }

    public int getTurnId() {
        return turnId;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }


    @Override
    public String toString() {
        return "Guess{" +
                "guessId=" + guessId +
                ", turnId=" + turnId +
                ", cardId=" + cardId +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
