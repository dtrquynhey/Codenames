package views.gui;

import controllers.AccountController;
import repositories.GameRepository;
import repositories.HistoryRepository;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.ScrollPane;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameHistoryPanel extends Panel {

    public GameHistoryPanel(AccountController accountController) {
        super();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("Your Game History", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);

        Label lblUsername = new Label("Username: " + accountController.getAccount().getUsername(), Font.PLAIN, 16 , Color.WHITE );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 15, 0);
        centerGridBagPanel.add(lblUsername, gridBagConstraints);

        Object[] columnNames = { "Date", "Play as", "Result" };
        Object[][] rowData = new HistoryRepository().getHistory(accountController.getAccount().toString());

        if (rowData.length == 0) {
            Label labelHistory = new Label("No History", Font.BOLD, 25, Color.WHITE);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = new Insets(0, 0, 10, 0);
            centerGridBagPanel.add(labelHistory, gridBagConstraints);
        } else {

            // Initializing the JTable
            Table table = new Table(rowData, columnNames);
            JScrollPane sp = new ScrollPane(table);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 3;
            gridBagConstraints.insets = new Insets(0, 0, 10, 0);
            centerGridBagPanel.add(sp, gridBagConstraints);
        }

        RoundedButton buttonGoBack = new RoundedButton("Go Back", 150, 42, CustomColor.RED.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        centerGridBagPanel.add(buttonGoBack, gridBagConstraints);

        buttonGoBack.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(GameHistoryPanel.this);
            mainFrame.goBack();
        });
    }
}
