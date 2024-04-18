package views.gui;

import controllers.AccountController;
import controllers.GameController;
import controllers.PlayerController;
import views.customPalettes.Panel;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends Panel {

    public WelcomePanel(AccountController accountController, PlayerController playerController) {
        super();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("Welcome to Codenames, " + accountController.getMainAccount().getUsername() + "!", 35, CustomColor.TEXT.getColor());
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

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 160, 42, CustomColor.YELLOW.getColor().darker());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonReadRules, gridBagConstraints);

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
            RoomCreationPanel roomCreationPanel = new RoomCreationPanel(new GameController(), accountController, playerController);
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showPanel(roomCreationPanel);
        });

        buttonViewHistory.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showPanel(new GameHistoryPanel(accountController));
        });

        buttonReadRules.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showRulesPanel();
        });

        buttonLogOut.addActionListener(e -> {
            accountController.logOut();
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showMainPanel();
        });

        buttonDeleteAccount.addActionListener(e -> {
            accountController.deleteAccount(accountController.getMainAccount().getUsername());
            accountController.logOut();
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showMainPanel();
        });
    }
}
