package controllers;

import contracts.IGameContract;
import controllers.enums.GuessResult;
import models.Card;
import models.Game;
import models.Team;
import models.enums.Color;
import models.enums.GameResult;
import repositories.CardRepository;
import repositories.DbConfig;
import repositories.mappers.CardMapper;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;


public class GameController implements IGameContract {

    private Game game;
    private String currentPlayer;
    public String currentClue;
    private int numOfGuesses;

    public List<Card> guessedCards;
    public List<Card> allCards;
    private Team currentTeam;

    public GameController() {
        guessedCards = new ArrayList<>();
        Connection connection = DbConfig.getConnection();

        CardRepository cardRepository = new CardRepository(connection, new CardMapper());
        CardController cardController = CardController.getInstance(cardRepository);

        List<String> randomWords = generateRandomWords();
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

    public void setNumOfGuesses(int numOfGuesses) {
        this.numOfGuesses = numOfGuesses;
    }
    public void createGame() {
        this.game = new Game();
    }

    public boolean isAvailableGuess() {
        return numOfGuesses > 0;
    }

    public GuessResult guessCard(Card card) {
        guessedCards.add(card);
        if (card.getColor() == Color.ASSASSIN) {
            return GuessResult.ASSASSIN_GUESS;
        } else if (card.getColor() == Color.NEUTRAL || card.getColor() != currentTeam.getColor()) {
            return GuessResult.NEUTRAL_OPPONENT_GUESS;
        } else {
            return GuessResult.RIGHT_GUESS;
        }
    }

    public void declareWinner(Team winningTeam) {
        System.out.println(winningTeam.getColor() + " team wins!");
    }

    public void declareLoser(Team losingTeam) {
        System.out.println(losingTeam.getColor() + " team loses!");
    }

    public GameResult determineGameResult() {
        if (getRedTeam().getScore() == 9) {
            return GameResult.RED_WIN;
        } else if (getBlueTeam().getScore() == 8) {
            return GameResult.BLUE_WIN;
        }
        return GameResult.ON_GOING;
    }
    public boolean isGameOver() {
        int redTeamCount = 0;
        int blueTeamCount = 0;
        for (Card card : guessedCards) {
            if (card.getColor() == Color.ASSASSIN) {
                Team losingTeam = currentTeam;
                declareLoser(losingTeam);
                return true;

            } else if (card.getColor() == getRedTeam().getColor()) {
                redTeamCount++;
            } else if (card.getColor() == getBlueTeam().getColor()) {
                blueTeamCount++;
            }

        }

        if (redTeamCount == 9) {
            declareWinner(getRedTeam());
            return true;
        }

        if (blueTeamCount == 8) {
            declareWinner(getBlueTeam());
            return true;
        }

        return false;
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

    @Override
    public List<String> generateRandomWords() {
        List<String> randomWords = new ArrayList<>();
        List<String> wordList = loadWords("src/words.txt");

        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            int index = rand.nextInt(wordList.size());
            randomWords.add(wordList.get(index));
        }
        return randomWords;
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

    public int getNumOfGuesses() {
        return numOfGuesses;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setInitialTeam() {
        this.currentTeam = getRedTeam();
        this.currentPlayer = getRedTeam().getSpymaster();
    }

    public void decreaseNumOfGuess() {
        this.numOfGuesses--;
    }
}
