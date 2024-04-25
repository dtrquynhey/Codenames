package views.gui;

import controllers.AccountController;
import controllers.GameController;
import controllers.TeamController;
import controllers.enums.RoomCreationResult;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class RoomCreationPanel extends Panel {

    private final AccountController accountController;
    private final GameController gameController;
    private final PlayersNamePanel playersNamePanel;


    public RoomCreationPanel(GameController gameController, AccountController accountController) {
        super();
        this.accountController = accountController;
        this.gameController = gameController;

        Label loggedAccountLabel = new Label("Logged in as: " + accountController.getAccount(), Font.BOLD, 16, CustomColor.TEXT.getColor());
        topFlowPanel.add(loggedAccountLabel);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("NEW GAME", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle, gridBagConstraints);

        playersNamePanel = new PlayersNamePanel(accountController.getAccounts().getFirst().getUsername());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(playersNamePanel, gridBagConstraints);

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


        labelLoginClickedHandler(playersNamePanel.getLabelLogin1(), 1);
        labelLoginClickedHandler(playersNamePanel.getLabelLogin2(), 2);
        labelLoginClickedHandler(playersNamePanel.getLabelLogin3(), 3);

        buttonCreateRoom.addActionListener(e -> buttonCreateRoomClickedHandler());

        buttonGoBack.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(RoomCreationPanel.this);
            mainFrame.goBack();
        });
    }

    private void labelLoginClickedHandler(Label labelLogin, int index) {
        labelLogin.setClickable(true);
        IconTextFieldPanel textField = playersNamePanel.getPlayerTextFields()[index];
        labelLogin.addActionListener(label -> {
            if (labelLogin.getText().equals("Log In")) {
                PopupFrame loginFrame = new PopupFrame();
                LoginPanel loginPanel = new LoginPanel(this.accountController);
                loginFrame.setContentPane(loginPanel);

                loginPanel.onLoginSuccess(() -> {
                    loginFrame.dispose();
                    textField.setTextFieldUsername(String.valueOf(accountController.getAccounts().getLast().getUsername()));
                    textField.getTextField().setEnabled(false);
                    labelLogin.setText("Log Out");

                    revalidate();
                    repaint();
                });
            } else {
                accountController.removeAccount(accountController.getAccounts().getLast().getUsername());
                textField.setTextFieldUsername("");
                textField.getTextField().setEnabled(true);
                labelLogin.setText("Log In");

                revalidate();
                repaint();
            }
        });
    }

    private void buttonCreateRoomClickedHandler() {
        String[] playerNicknames = playersNamePanel.getPlayerNicknames();
        switch (isValidNicknames(playerNicknames)) {
            case MISSING_NAMES -> playersNamePanel.showError("All player names are required.");
            case DUPLICATE_NAMES -> playersNamePanel.showError("Names must be unique.");
            case SUCCESS -> {
                gameController.getGame().setPlayers(playerNicknames);
                TeamSetupPanel teamSetupPanel = new TeamSetupPanel(accountController, gameController, new TeamController());
                MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(RoomCreationPanel.this);
                mainFrame.showPanel(teamSetupPanel);
            }
        }
    }

    public RoomCreationResult isValidNicknames(String[] nicknames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : nicknames) {
            if (name == null || name.trim().isEmpty()) {
                return RoomCreationResult.MISSING_NAMES;
            }
            if (uniqueNames.contains(name)) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
            uniqueNames.add(name);
        }
        return RoomCreationResult.SUCCESS;
    }
}
