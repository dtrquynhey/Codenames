package views.gui;

import controllers.AccountController;
import controllers.GameController;
import controllers.PlayerController;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class RoomCreationPanel extends Panel {

    public RoomCreationPanel(GameController gameController, AccountController accountController, PlayerController playerController) {
        super();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("NEW GAME", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);

        PlayersNamePanel playersNamePanel = new PlayersNamePanel(accountController.getAccounts().getFirst().getUsername());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(playersNamePanel, gridBagConstraints);

        Label[] labelLogins = playersNamePanel.getLabelLogins();
        for (int i = 0; i < labelLogins.length; i++) {

            int currentI= i+1;
            IconTextFieldPanel currentTextField = playersNamePanel.getPlayerTextFields()[i+1];
            Label currentLoginLabel = labelLogins[i];

            labelLogins[i].setClickable(true);
            labelLogins[i].addActionListener(label -> {

                if (currentLoginLabel.getText().equals("Log In")) {
                    PopupFrame loginFrame = new PopupFrame();
                    LoginPanel loginPanel = new LoginPanel(accountController);
                    loginFrame.setContentPane(loginPanel);

                    accountController.accountIndex = currentI;
                    loginPanel.onLoginSuccess(() -> {
                        loginFrame.dispose();
                        currentTextField.setTextFieldUsername(String.valueOf(accountController.getAccounts().get(currentI).getUsername()));
                        currentTextField.getTextField().setEnabled(false);
                        currentLoginLabel.setText("Log Out");
                    });
                } else {
                    accountController.removeAccount(playersNamePanel.getPlayerTextFields()[currentI].getTextFieldUsername());
                    currentTextField.setTextFieldUsername("");
                    currentTextField.getTextField().setEnabled(true);
                    currentLoginLabel.setText("Log In");
                }
            });
        }


        RoundedButton buttonCreateRoom = new RoundedButton("Create Room", 160, 42, CustomColor.PINK.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonCreateRoom, gridBagConstraints);

        RoundedButton buttonGoBack = new RoundedButton("Go Back", 150, 42, CustomColor.RED.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonGoBack, gridBagConstraints);

        gameController.createGame();

        buttonCreateRoom.addActionListener(e -> {
            String[] playerNicknames = playersNamePanel.getPlayerNicknames();
            switch (playerController.isValidPlayerNames(playerNicknames)) {
                case MISSING_NAMES -> playersNamePanel.showError("All player names are required.");
                case DUPLICATE_NAMES -> playersNamePanel.showError("Names must be unique.");
                case SUCCESS -> {
                    playerController.setPlayers(playerNicknames);
                    gameController.getGame().setPlayers(playerController.getPlayers());
                    new MessageDialog(this, "Room is created.", "Room Creation Success");

                    TeamSelectionPanel teamSetupPanel = playerController.initializeTeamSetUpPanel(gameController);
                    MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(RoomCreationPanel.this);
                    mainFrame.showPanel(teamSetupPanel);
                }
            }
        });

        buttonGoBack.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(RoomCreationPanel.this);
            mainFrame.goBack();
        });
    }
}
