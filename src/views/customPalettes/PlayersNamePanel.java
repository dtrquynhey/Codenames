package views.customPalettes;
import views.customPalettes.enums.CustomColor;
import views.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayersNamePanel extends ContainerPanel {


    public IconTextFieldPanel[] getPlayerTextFields() {
        return playerTextFields;
    }

    private final IconTextFieldPanel[] playerTextFields;
    private final IconLabelPanel errorPanel;



    public Label[] getLabelLogins() {
        return labelLogins;
    }

    private final Label[] labelLogins;

    public PlayersNamePanel(String player1) {
        super(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(500, 300));
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label labelEnterNicknames = new Label("Enter nicknames to play anonymously", Font.PLAIN, 16, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(labelEnterNicknames, gridBagConstraints);

        Label labelOrLogin = new Label("or login to save game history", Font.PLAIN, 16, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(labelOrLogin, gridBagConstraints);


        playerTextFields = new IconTextFieldPanel[4];
        labelLogins = new Label[3];

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        IconTextFieldPanel textFieldPlayer1 = new IconTextFieldPanel(player1, "src/assets/icon-player1.png");
        textFieldPlayer1.setTextFieldUsername(player1);
        textFieldPlayer1.getTextField().setEnabled(false);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        add(textFieldPlayer1, gridBagConstraints);

        playerTextFields[0] = textFieldPlayer1;

        for (int i = 1; i < playerTextFields.length; i++) {
            IconTextFieldPanel textField = new IconTextFieldPanel("Player " + (i + 1), "src/assets/icon-player"+ (i + 1) + ".png");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 3;
            gridBagConstraints.insets = new Insets(5, 0, 0, 0);
            add(textField, gridBagConstraints);

            playerTextFields[i] = textField;
        }

        for (int i = 0; i < labelLogins.length; i++) {
            Label labelLogin = new Label("Log In", Font.HANGING_BASELINE, 16, CustomColor.TEXT.getColor());
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 4;
            gridBagConstraints.insets = new Insets(5, 0, 0, 0);
            add(labelLogin, gridBagConstraints);


            labelLogins[i] = labelLogin;

        }

        errorPanel = new IconLabelPanel("");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        add(errorPanel, gridBagConstraints);

        setVisible(true);
    }

    public String[] getPlayerNicknames() {
        String[] nicknames = new String[playerTextFields.length];
        for (int i = 0; i < playerTextFields.length; i++) {
            nicknames[i] = playerTextFields[i].getTextFieldUsername();
        }
        return nicknames;
    }

    public void showError(String message) {
        errorPanel.setIconLabel("src/assets/icon-error.png");
        errorPanel.setMessageLabel(message);
    }
}
