package views.gui;

import controllers.AccountController;
import controllers.GameController;
import views.customPalettes.Panel;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends Panel {

    public HomePanel(AccountController accountController) {
        super();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("Welcome to Codenames, " + accountController.getAccount().getUsername() + "!", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);

        RoundedButton buttonNewGame = new RoundedButton("New Game", 160, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonNewGame, gridBagConstraints);

        RoundedButton buttonViewHistory = new RoundedButton("View History", 160, 42, CustomColor.ORANGE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonViewHistory, gridBagConstraints);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 160, 42, CustomColor.RED.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonLogOut, gridBagConstraints);

        RoundedButton buttonDeleteAccount = new RoundedButton("Delete Account", 180, 42, CustomColor.PINK.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonDeleteAccount, gridBagConstraints);

        buttonNewGame.addActionListener(e -> {
            GameController gameController = new GameController();
            gameController.setGame();
            accountController.initializeAccounts();
            accountController.setFirstAccount(accountController.getAccount().getUsername());
            RoomCreationPanel roomCreationPanel = new RoomCreationPanel(gameController, accountController);
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(HomePanel.this);
            mainFrame.showPanel(roomCreationPanel);
        });

        buttonViewHistory.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(HomePanel.this);
            mainFrame.showPanel(new GameHistoryPanel(accountController));
        });

        buttonLogOut.addActionListener(e -> {
            accountController.logOut();
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(HomePanel.this);
            mainFrame.showMainPanel();
        });

        buttonDeleteAccount.addActionListener(e -> {
            accountController.deleteAccount(accountController.getAccount().getUsername());
            accountController.logOut();
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(HomePanel.this);
            mainFrame.showMainPanel();
        });
    }
}
