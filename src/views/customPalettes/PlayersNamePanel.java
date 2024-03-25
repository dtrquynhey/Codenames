package views.customPalettes;
import views.customPalettes.enums.CustomColor;

import java.awt.*;

public class PlayersNamePanel extends ContainerPanel {


    private final IconTextFieldPanel[] playerTextFields;
    private final IconLabelPanel errorPanel;

    public PlayersNamePanel() {
        super(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(390, 300));
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label labelEnterPlayer = new Label("Enter 4 player nicknames.", Font.PLAIN, 16, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(labelEnterPlayer, gridBagConstraints);

        playerTextFields = new IconTextFieldPanel[4];

        for (int i = 0; i < playerTextFields.length; i++) {
            IconTextFieldPanel textField = new IconTextFieldPanel("Player " + (i + 1), "src/assets/icon-player"+ (i + 1) + ".png");
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 1;
            gridBagConstraints.insets = new Insets(i == 0 ? 15 : 5, 0, 0, 0);
            add(textField, gridBagConstraints);
            playerTextFields[i] = textField;
        }

        errorPanel = new IconLabelPanel("");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
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
