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
import views.customPalettes.TextField;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GamePlayPanel extends MainPanel {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public GamePlayPanel(Map<Color, Map<Role, Player>> playerSelectedTeams) {
        super();

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

        GameController gameController = new GameController();
        Connection connection;
        try {
            connection = DbConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CardRepository cardRepository = new CardRepository(connection, new CardMapper());
        CardController cardController = CardController.getInstance(cardRepository);


        List<String> randomWords = gameController.generateRandomWords();
        List<Card> cards = cardController.generateCards(randomWords);


        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        Board spymasterBoard = new Board(cards, false);
        cardPanel.add(spymasterBoard, "SPYMASTER_BOARD");

        Board operativeBoard = new Board(cards, true);
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
        });

        buttonEndGuess.addActionListener(e -> {
            cardLayout.show(cardPanel, "SPYMASTER_BOARD");
            textFieldHint.setEnabled(true);
            textFieldNumOfWords.setEnabled(true);
            buttonEndGuess.setVisible(false);
            buttonGiveClue.setVisible(true);
        });



    }
}
