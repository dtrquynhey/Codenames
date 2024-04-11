package views.gui;


import controllers.CardController;
import controllers.GameController;
import models.Card;
import models.Player;
import models.enums.Color;
import models.enums.Role;
import repositories.CardRepository;
import repositories.DbConfig;
import repositories.mappers.CardMapper;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.TextField;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GamePlayPanel extends MainPanel {

    private GameController gameController;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    public GamePlayPanel(Map<Color, Map<Role, Player>> playerSelectedTeams) {
        super();

        gameController = new GameController();

        gameController.addTeams(playerSelectedTeams);

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonExitGame = new RoundedButton("Exit Game", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonExitGame);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        RedTeamGameLog redTeamGameLog = new RedTeamGameLog(playerSelectedTeams.get(Color.RED));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        centerGridBagPanel.add(redTeamGameLog, gridBagConstraints);

        //gameController = new GameController();




        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        Board spymasterBoard = new Board(gameController.allCards, false,gameController);
        cardPanel.add(spymasterBoard, "SPYMASTER_BOARD");

        Board operativeBoard = new Board(gameController.allCards, true,gameController);
        operativeBoard.setCardColor(CustomColor.CARD_NEUTRAL.getColor());
        cardPanel.add(operativeBoard, "OPERATIVE_BOARD");

        cardLayout.show(cardPanel, "SPYMASTER_BOARD");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 25, 0, 25);
        centerGridBagPanel.add(cardPanel, gridBagConstraints);


        BlueTeamGameLog blueTeamGameLog = new BlueTeamGameLog(playerSelectedTeams.get(Color.BLUE));
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(blueTeamGameLog, gridBagConstraints);


        TextField textFieldHint = new TextField("Type your hint", new Dimension(300, 42));
        bottomFlowPanel.add(textFieldHint);

        TextField textFieldNumOfWords = new TextField("", new Dimension(50, 42));
        bottomFlowPanel.add(textFieldNumOfWords);

        RoundedButton buttonGiveClue = new RoundedButton("Give Clue", 130, 42, CustomColor.GREEN.getColor());
        bottomFlowPanel.add(buttonGiveClue);

        RoundedButton buttonEndGuess = new RoundedButton("End Guess", 140, 42, CustomColor.YELLOW.getColor());
        bottomFlowPanel.add(buttonEndGuess);
        buttonEndGuess.setVisible(false);

        buttonGiveClue.addActionListener(e -> {
            cardLayout.show(cardPanel, "OPERATIVE_BOARD");
            textFieldHint.setEnabled(false);
            textFieldNumOfWords.setEnabled(false);
            buttonEndGuess.setVisible(true);
            buttonGiveClue.setVisible(false);

            if(textFieldHint.getText().isEmpty()){
                gameController.currentClue = "";
            }else{
                gameController.currentClue = textFieldHint.getText();

            }

            if(textFieldNumOfWords.getText().isEmpty()){
                gameController.numOfGuesses = 1;
            }else{
                gameController.numOfGuesses = Integer.parseInt(textFieldNumOfWords.getText())+1;

            }



            gameController.changeTurn();
        });

        buttonEndGuess.addActionListener(e -> {
            cardLayout.show(cardPanel, "SPYMASTER_BOARD");
            textFieldHint.setEnabled(true);
            textFieldNumOfWords.setEnabled(true);
            textFieldHint.setText("");
            textFieldNumOfWords.setText("");
            buttonEndGuess.setVisible(false);
            buttonGiveClue.setVisible(true);

            gameController.currentClue = textFieldHint.getText();
            gameController.numOfGuesses = 0;
            gameController.changeTurn();
        });



    }
}
