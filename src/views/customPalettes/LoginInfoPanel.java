package views.customPalettes;

import views.customPalettes.enums.CustomColor;
import java.awt.*;

public class LoginInfoPanel extends ContainerPanel {

    private final IconTextFieldPanel usernamePanel;
    private final PasswordPanel passwordPanel;
    private final IconLabelPanel errorPanel;
    public LoginInfoPanel() {
        super(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(390, 200));

        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        usernamePanel = new IconTextFieldPanel("Username", "src/assets/icon-username.png");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(usernamePanel, gridBagConstraints);

        passwordPanel = new PasswordPanel("Password");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(passwordPanel, gridBagConstraints);

        errorPanel = new IconLabelPanel("");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        errorPanel.setVisible(false);
        add(errorPanel, gridBagConstraints);
    }

    public void resetPanel() {
        usernamePanel.setTextFieldUsername("");
        passwordPanel.resetPanel();
    }

    public String getUsername() {
        return usernamePanel.getTextFieldUsername();
    }

    public String getPassword() {
        return passwordPanel.getPassword();
    }

    public void showError(String message) {
        errorPanel.setIconLabel("src/assets/icon-error.png");
        errorPanel.setMessageLabel(message);
    }

}
