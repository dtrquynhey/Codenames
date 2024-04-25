package controllers;

import controllers.enums.GuessResult;
import models.Card;
import models.Game;
import models.Team;
import models.enums.Color;
import models.enums.GameResult;
import repositories.GameRepository;
import repositories.HistoryRepository;

import java.util.ArrayList;
import java.util.List;


public class GameController {

    private Game game;
    private String currentPlayer;
    private int numOfGuess;

    public List<Card> guessedCards;
    public List<Card> allCards;
    private Team currentTeam;

    public GameController() {
        guessedCards = new ArrayList<>();
        CardController cardController = CardController.getInstance();
        List<String> randomWords = cardController.generateRandomWords();
        allCards = cardController.generateCards(randomWords);
    }

    public Game getGame() {
        return game;
    }

    public Team getRedTeam() {
        return getGame().getRedTeam();
    }

    public Team getBlueTeam() {
        return getGame().getBlueTeam();
    }

    public void setNumOfGuess(int numOfGuess) {
        this.numOfGuess = numOfGuess;
    }
    public void setGame() {
        this.game = new Game();
    }

    public boolean isAvailableGuess() {
        return numOfGuess > 0;
    }

    public GuessResult guessCard(Card card) {
        guessedCards.add(card);
        if (card.getColor() == Color.ASSASSIN) {
            return GuessResult.ASSASSIN_GUESSED;
        } else if (card.getColor() == Color.NEUTRAL) {
            return GuessResult.NEUTRAL_GUESSED;
        } else if (card.getColor() != currentTeam.getColor()) {
            return GuessResult.OPPONENT_GUESSED;
        } else {
            return GuessResult.RIGHT_GUESSED;
        }
    }


    public GameResult determineGameResult() {

        int redCardsCount = 0;
        int blueCardsCount = 0;
        for (Card card : guessedCards) {
            if (card.getColor() == getRedTeam().getColor()) {
                redCardsCount++;
            } else if (card.getColor() == getBlueTeam().getColor()) {
                blueCardsCount++;
            }
        }

        if (redCardsCount == 9) {
            return GameResult.RED_WIN;
        } else if (blueCardsCount == 8) {
            return GameResult.BLUE_WIN;
        }

        if (getOpponentTeam().isWinner()) {
            if (currentTeam.getColor() == Color.RED) {
                return GameResult.BLUE_WIN;
            } else {
                return GameResult.RED_WIN;
            }
        }
        return GameResult.ON_GOING;
    }

    public void changeTurn() {

        if (currentPlayer.equals(getRedTeam().getSpymaster())) {
            currentPlayer = getRedTeam().getOperative();
        } else if (currentPlayer.equals(getRedTeam().getOperative())) {
            currentPlayer = getBlueTeam().getSpymaster();
            currentTeam = getBlueTeam();

        } else if (currentPlayer.equals(getBlueTeam().getSpymaster())) {
            currentPlayer = getBlueTeam().getOperative();

        } else if (currentPlayer.equals(getBlueTeam().getOperative())) {
            currentPlayer = getRedTeam().getSpymaster();
            currentTeam = getRedTeam();
        }
    }

    public int getNumOfGuess() {
        return numOfGuess;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public Team getOpponentTeam() {
        if (currentTeam.getColor() == Color.RED) {
            return getBlueTeam();
        } else {
            return getRedTeam();
        }
    }

    public void increaseCurrentTeamScore() {
        currentTeam.increaseScore();
    }
    public void increaseOpponentScore() {
        getOpponentTeam().increaseScore();
    }

    public void setInitialTeam() {
        this.currentTeam = getRedTeam();
        this.currentPlayer = getRedTeam().getSpymaster();
    }

    public void decreaseNumOfGuess() {
        this.numOfGuess--;
    }

    public void saveGame(String account) {
        int savedGameId = new GameRepository().insertGame(this.game);
        //String account = AccountController.getInstance().getAccount().toString();
        new HistoryRepository().insertHistory(account, savedGameId);
    }

}
