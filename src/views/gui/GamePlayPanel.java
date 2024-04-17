package views.gui;


import controllers.AccountController;
import controllers.GameController;
import models.Card;
import views.customPalettes.Panel;
import views.customPalettes.TextField;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class GamePlayPanel extends Panel {

    private GameController gameController;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    public GamePlayPanel(GameController gameController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.YELLOW.getColor().darker());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonExitGame = new RoundedButton("Exit Game", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonExitGame);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        RedTeamGameLog redTeamGameLog = new RedTeamGameLog(gameController);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        centerGridBagPanel.add(redTeamGameLog, gridBagConstraints);


        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
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


        BlueTeamGameLog blueTeamGameLog = new BlueTeamGameLog(gameController);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(blueTeamGameLog, gridBagConstraints);


        TextField textFieldHint = new TextField("Type your hint", new Dimension(300, 42));
        bottomFlowPanel.add(textFieldHint);

        TextField textFieldNumOfGuess = new TextField("", new Dimension(60, 42));
        bottomFlowPanel.add(textFieldNumOfGuess);

        RoundedButton buttonGiveClue = new RoundedButton("Give Clue", 130, 42, CustomColor.GREEN.getColor());
        bottomFlowPanel.add(buttonGiveClue);

        RoundedButton buttonEndGuess = new RoundedButton("End Guess", 140, 42, CustomColor.YELLOW.getColor());
        bottomFlowPanel.add(buttonEndGuess);
        buttonEndGuess.setVisible(false);

        buttonGiveClue.addActionListener(e -> {
            cardLayout.show(cardPanel, "OPERATIVE_BOARD");
            textFieldHint.setEnabled(false);
            textFieldNumOfGuess.setEnabled(false);
            buttonEndGuess.setVisible(true);
            buttonGiveClue.setVisible(false);

            if (textFieldHint.getText().isEmpty()){
                gameController.currentClue = "";
            } else {
                gameController.currentClue = textFieldHint.getText();
            }

            if (textFieldNumOfGuess.getText().isEmpty()){
                gameController.numOfGuesses = 1;
            } else {
                gameController.numOfGuesses = Integer.parseInt(textFieldNumOfGuess.getText()) + 1;

            }
            gameController.currentClue = textFieldHint.getText();
            gameController.numOfGuesses = Integer.parseInt(textFieldNumOfGuess.getText()) + 1;
            gameController.changeTurn();

        });

        buttonEndGuess.addActionListener(e -> {
            cardLayout.show(cardPanel, "SPYMASTER_BOARD");
            textFieldHint.setEnabled(true);
            textFieldNumOfGuess.setEnabled(true);
            textFieldHint.setText("");
            textFieldNumOfGuess.setText("");
            buttonEndGuess.setVisible(false);
            buttonGiveClue.setVisible(true);

            gameController.currentClue = textFieldHint.getText();
            gameController.numOfGuesses = 0;
            gameController.changeTurn();
            for (Card c : gameController.flippedCards) {

            }
        });


        buttonLogOut.addActionListener(e -> {

            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(GamePlayPanel.this);
            mainFrame.showMainPanel();
        });
    }
}
