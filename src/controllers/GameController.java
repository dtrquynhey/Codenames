package controllers;

import contracts.IGameContract;
import models.Card;
import models.Player;
import models.Team;
import models.enums.Color;
import models.enums.Role;
import repositories.CardRepository;
import repositories.DbConfig;
import repositories.TeamRepository;
import repositories.mappers.CardMapper;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


public class GameController implements IGameContract {

    private static GameController _instance;
    private String currentPlayer;
    public String currentClue;
    public int numOfGuesses;

    private ArrayList<Card> flippedCards;
    public ArrayList<Card> allCards;
    private Team currentTeam;
    private Team redTeam;
    private Team blueTeam;
    public static GameController get_instance() {
        return _instance;
    }

    public GameController(){

        flippedCards = new ArrayList<Card>();
        Connection connection;
        try {
            connection = DbConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CardRepository cardRepository = new CardRepository(connection, new CardMapper());
        CardController cardController = CardController.getInstance(cardRepository);


        java.util.List<String> randomWords = generateRandomWords();
        allCards = (ArrayList<Card>) cardController.generateCards(randomWords);
        //listOfTeams = new ArrayList<Team>();
        //currentPlayer = listOfTeams.getFirst().getSpymaster();
    }

    public void flipCard(Card card){

        flippedCards.add(card);
        System.out.println(card.getWord());

        numOfGuesses -= 1;

        System.out.println(flippedCards);
    }

    public boolean canContinueGuessing(Card card){
        if (card.getColor() == Color.ASSASSIN) {
            numOfGuesses = 0;

            return false;
        } else if (card.getColor() == Color.NEUTRAL) {
            numOfGuesses = 0;
            return false;
        } else return card.getColor() == currentTeam.getColor() && numOfGuesses > 0 ;
    }

    public void declareWinner(Team winningTeam){
        System.out.println(winningTeam.getColor() + " team wins!");
    }
    public void declareLoser(Team losingTeam){
        System.out.println(losingTeam.getColor() + " team loses!");
    }

    public boolean IsGameOver(){
        int redTeamCount = 0;
        int blueTeamCount = 0;
        for (Card card : flippedCards) {
            if (card.getColor() == Color.ASSASSIN) {
               Team losingTeam = currentTeam;
               declareLoser(losingTeam);
                return true;

            } else if (card.getColor() == redTeam.getColor()) {
                redTeamCount++;
            } else if (card.getColor() == blueTeam.getColor()) {
                blueTeamCount++;
            }

        }

        if(redTeamCount == 9){
            declareWinner(redTeam);
            return true;
        }

        if(blueTeamCount == 8){
            declareWinner(blueTeam);
            return true;
        }

        return false;
    }



    public void changeTurn(){

        System.out.println(redTeam);
        if (Objects.equals(currentPlayer, redTeam.getSpymaster())){
            currentPlayer = redTeam.getOperative();
        } else if (Objects.equals(currentPlayer,redTeam.getOperative())) {
            currentPlayer = blueTeam.getSpymaster();
            currentTeam = blueTeam;

        } else if (Objects.equals(currentPlayer, blueTeam.getSpymaster())) {
            currentPlayer = blueTeam.getOperative();

        } else if (Objects.equals(currentPlayer, blueTeam.getOperative())) {
            currentPlayer = redTeam.getSpymaster();
            currentTeam = redTeam;
        }



        System.out.println(currentPlayer);
        System.out.println(currentTeam);
    }

    public void addTeams(Map<Color, Map<Role, Player>> playerSelectedTeams){
        Map<Role,Player> redTeamMap = playerSelectedTeams.get(Color.RED);


        redTeam = new Team(redTeamMap.get(Role.SPYMASTER),redTeamMap.get(Role.OPERATIVE),Color.RED,false);
        //System.out.println(redTeam);

        Map<Role,Player> blueTeamMap = playerSelectedTeams.get(Color.BLUE);

        blueTeam = new Team(blueTeamMap.get(Role.SPYMASTER),blueTeamMap.get(Role.OPERATIVE),Color.BLUE,false);


        currentPlayer = redTeam.getSpymaster();
        currentTeam = redTeam;

       // System.out.println(currentPlayer);

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
}
