package models;

public class Clue {

    private int clueId;
    private int turnId;
    private int cardId;
    private String clueWord;
    private int count;


    public Clue() {
    }

    public Clue(int clueId, int turnId, int wordCardId, String clueWord, int count) {
        this.clueId = clueId;
        this.turnId = turnId;
        this.cardId = wordCardId;
        this.clueWord = clueWord;
        this.count = count;
    }


    public int getClueId() {
        return clueId;
    }

    public void setClueId(int clueId) {
        this.clueId = clueId;
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

    public void setCardId(int wordCardId) {
        this.cardId = wordCardId;
    }

    public String getClueWord() {
        return clueWord;
    }

    public void setClueWord(String clueWord) {
        this.clueWord = clueWord;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "Clue{" +
                "clueId=" + clueId +
                ", turnId=" + turnId +
                ", cardId=" + cardId +
                ", clueWord='" + clueWord + '\'' +
                ", count=" + count +
                '}';
    }
}
