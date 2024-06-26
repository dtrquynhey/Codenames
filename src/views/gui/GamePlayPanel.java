package views.gui;


import controllers.AccountController;
import controllers.GameController;
import models.enums.Color;
import models.enums.GameResult;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.TextField;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePlayPanel extends Panel {

    private final GameController gameController;
    private final AccountController accountController;
    private final JPanel cardPanel;
    private final CardLayout cardLayout;
    public Board spymasterBoard;
    public Board operativeBoard;
    RedTeamGameLog redTeamGameLog;
    BlueTeamGameLog blueTeamGameLog;
    TextField textFieldClue;
    TextField textFieldNumOfGuess;
    Label labelRemainingGuess;
    RoundedButton buttonGiveClue;
    RoundedButton buttonEndGuess;

    public GamePlayPanel(AccountController accountController, GameController gameController) {
        super();
        this.gameController = gameController;
        this.accountController = accountController;


        Label loggedAccountLabel = new Label("Logged in as: " + accountController.getAccount(), Font.BOLD, 16, CustomColor.TEXT.getColor());
        topFlowPanel.add(loggedAccountLabel);

        RoundedButton buttonExitGame = new RoundedButton("Exit Game", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonExitGame);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        redTeamGameLog = new RedTeamGameLog(gameController);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(redTeamGameLog, gridBagConstraints);


        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        spymasterBoard = new Board(gameController.allCards);
        cardPanel.add(spymasterBoard, "SPYMASTER_BOARD");
        operativeBoard = new Board(gameController.allCards);
        operativeBoard.setCardColor(CustomColor.CARD_NEUTRAL.getColor());
        cardPanel.add(operativeBoard, "OPERATIVE_BOARD");

        cardLayout.show(cardPanel, "SPYMASTER_BOARD");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        centerGridBagPanel.add(cardPanel, gridBagConstraints);


        blueTeamGameLog = new BlueTeamGameLog(gameController);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(blueTeamGameLog, gridBagConstraints);

        Label label2 = new Label("Remaining guess(es): ", Font.BOLD, 16, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(label2, gridBagConstraints);

        labelRemainingGuess = new Label("", Font.BOLD, 18, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(labelRemainingGuess, gridBagConstraints);


        textFieldClue = new TextField("Type your clue", new Dimension(300, 42));
        bottomFlowPanel.add(textFieldClue);

        textFieldNumOfGuess = new TextField("", new Dimension(60, 42));
        textFieldNumOfGuess.setMaxCharacters(1);
        bottomFlowPanel.add(textFieldNumOfGuess);

        buttonGiveClue = new RoundedButton("Give Clue", 130, 42, CustomColor.GREEN.getColor());
        bottomFlowPanel.add(buttonGiveClue);

        buttonEndGuess = new RoundedButton("End Guess", 140, 42, CustomColor.YELLOW.getColor());
        bottomFlowPanel.add(buttonEndGuess);
        buttonEndGuess.setVisible(false);

        setRedTeamBackground();

        buttonGiveClue.addActionListener(e -> {

            if (textFieldClue.getText().isEmpty()) {
                new MessageDialog(this, "Please enter clue.", "Game Play Error", "OK");
            } else if (textFieldNumOfGuess.getText().isEmpty()) {
                new MessageDialog(this, "Please enter number of word.", "Game Play Error", "OK");
            } else if (!Character.isDigit(textFieldNumOfGuess.getText().codePointAt(0))) {
                new MessageDialog(this, "Number of word field must be a digit.", "Game Play Error", "OK");
            } else {
                gameController.setNumOfGuess(Integer.parseInt(textFieldNumOfGuess.getText().trim()) + 1);
                labelRemainingGuess.setText(String.valueOf(gameController.getNumOfGuess()));
                gameController.changeTurn();

                showOperativeBoard();
                cardClickedHandler();
            }
        });

        buttonEndGuess.addActionListener(e -> {
            gameController.setNumOfGuess(0);
            labelRemainingGuess.setText(String.valueOf(gameController.getNumOfGuess()));
            gameController.changeTurn();

            if (gameController.getCurrentTeam().getColor() == Color.RED) {
                setRedTeamBackground();
            } else {
                setBlueTeamBackground();
            }
            showSpymasterBoard();


        });

        buttonExitGame.addActionListener(e -> buttonExitGameClickedHandler());
    }

    private void buttonExitGameClickedHandler() {
        gameController.getGame().setGameResult(GameResult.INCOMPLETE);
        HomePanel homePanel = new HomePanel(accountController);
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(GamePlayPanel.this);
        mainFrame.showPanel(homePanel);
    }

    private void cardClickedHandler() {
        for (int index = 0; index < operativeBoard.flippableCards.size(); index++) {

            int finalIndex = index;
            operativeBoard.flippableCards.get(index).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (gameController.allCards.get(finalIndex).getIsRevealed()) {
                        return;
                    }
                    if (gameController.isAvailableGuess()) {

                        gameController.allCards.get(finalIndex).setIsRevealed(true);

                        operativeBoard.flippableCards.get(finalIndex).flip();
                        spymasterBoard.flippableCards.get(finalIndex).flip();
                        operativeBoard.flippableCards.get(finalIndex).setEnabled(false);
                        spymasterBoard.flippableCards.get(finalIndex).setEnabled(false);
                        revalidate();
                        repaint();

                        switch (gameController.guessCard(gameController.allCards.get(finalIndex))) {
                            case RIGHT_GUESSED -> {
                                gameController.decreaseNumOfGuess();
                                labelRemainingGuess.setText(String.valueOf(gameController.getNumOfGuess()));

                                gameController.increaseCurrentTeamScore();
                                redTeamGameLog.setScore(gameController.getRedTeam().getScore());
                                blueTeamGameLog.setScore(gameController.getBlueTeam().getScore());
                            }
                            case NEUTRAL_GUESSED -> {
                                gameController.setNumOfGuess(0);
                                labelRemainingGuess.setText(String.valueOf(gameController.getNumOfGuess()));

                                new MessageDialog(GamePlayPanel.this, "You guessed Neutral card. Your turn is ended.", "Game Play", "OK");

                                buttonEndGuess.doClick();

                            }
                            case OPPONENT_GUESSED -> {
                                gameController.setNumOfGuess(0);
                                labelRemainingGuess.setText(String.valueOf(gameController.getNumOfGuess()));

                                gameController.increaseOpponentScore();
                                redTeamGameLog.setScore(gameController.getRedTeam().getScore());
                                blueTeamGameLog.setScore(gameController.getBlueTeam().getScore());

                                new MessageDialog(GamePlayPanel.this, "You guessed Opponent card. Your turn is ended.", "Game Play", "OK");
                                buttonEndGuess.doClick();
                            }
                            case ASSASSIN_GUESSED -> {
                                gameController.setNumOfGuess(0);
                                gameController.getOpponentTeam().setWinner(true);
                                new MessageDialog(GamePlayPanel.this, "You guessed Assassin card. Game is over!", "Game Play", "OK");
                            }
                        }

                        GameResult gameResult = gameController.determineGameResult();
                        switch (gameResult) {
                            case RED_WIN:
                            case BLUE_WIN:
                                String message;
                                if (gameResult == GameResult.RED_WIN) {
                                    gameController.getRedTeam().setWinner(true);
                                    gameController.getGame().setGameResult(GameResult.RED_WIN);
                                    message = "RED TEAM WINS!";
                                } else {
                                    gameController.getBlueTeam().setWinner(true);
                                    gameController.getGame().setGameResult(GameResult.BLUE_WIN);
                                    message = "BLUE TEAM WINS!";
                                }
                                new MessageDialog(GamePlayPanel.this, message, "Game Play", "Go Home");

                                gameController.saveGame(accountController.getAccount().toString());

                                HomePanel homePanel = new HomePanel(accountController);
                                MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(GamePlayPanel.this);
                                mainFrame.showPanel(homePanel);
                            case ON_GOING:
                                revalidate();
                                repaint();
                        }
                    }
                }
            });
        }
    }


    private void setRedTeamBackground() {
        setPanelsBackgroundColor(CustomColor.FRAME_RED.getColor());
        spymasterBoard.setBackgroundColor(CustomColor.FRAME_RED.getColor());
        operativeBoard.setBackgroundColor(CustomColor.FRAME_RED.getColor());
        textFieldClue.setBackground(CustomColor.CARD_RED.getColor().darker());
        textFieldNumOfGuess.setBackground(CustomColor.CARD_RED.getColor().darker());
    }

    private void setBlueTeamBackground() {
        setPanelsBackgroundColor(CustomColor.FRAME_BLUE.getColor());
        spymasterBoard.setBackgroundColor(CustomColor.FRAME_BLUE.getColor());
        operativeBoard.setBackgroundColor(CustomColor.FRAME_BLUE.getColor());
        textFieldClue.setBackground(CustomColor.CARD_BLUE.getColor().darker());
        textFieldNumOfGuess.setBackground(CustomColor.CARD_BLUE.getColor().darker());
    }

    private void showOperativeBoard() {
        cardLayout.show(cardPanel, "OPERATIVE_BOARD");
        textFieldClue.setEnabled(false);
        textFieldNumOfGuess.setEnabled(false);
        labelRemainingGuess.setVisible(true);
        buttonEndGuess.setVisible(true);
        buttonGiveClue.setVisible(false);
    }

    private void showSpymasterBoard() {
        cardLayout.show(cardPanel, "SPYMASTER_BOARD");
        textFieldClue.setEnabled(true);
        textFieldNumOfGuess.setEnabled(true);
        textFieldClue.setText("");
        textFieldNumOfGuess.setText("");
        labelRemainingGuess.setVisible(false);
        buttonEndGuess.setVisible(false);
        buttonGiveClue.setVisible(true);
    }
}
