package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import java.awt.*;

public class SignupInfoPanel extends ContainerPanel{


    private final IconTextFieldPanel usernamePanel;
    private final PasswordPanel passwordPanel;
    private final PasswordPanel confirmPasswordPanel;
    private final IconLabelPanel errorPanel;


    public SignupInfoPanel() {
        super(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(390, 220));
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        usernamePanel = new IconTextFieldPanel("Username", "src/assets/icon-username.png");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        add(usernamePanel, gridBagConstraints);

        passwordPanel = new PasswordPanel("Password");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(passwordPanel, gridBagConstraints);

        confirmPasswordPanel = new PasswordPanel("Confirm Password");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(confirmPasswordPanel, gridBagConstraints);

        errorPanel = new IconLabelPanel("");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        errorPanel.setVisible(true);
        add(errorPanel, gridBagConstraints);
    }

    public void resetPanel() {
        usernamePanel.setTextFieldUsername("");
        passwordPanel.resetPanel();
        confirmPasswordPanel.resetPanel();
        errorPanel.setVisible(false);
    }

    public String getUsername() {
        return usernamePanel.getTextFieldUsername();
    }

    public String getPassword() {
        return passwordPanel.getPassword();
    }
    public String getConfirmPassword() {
        return confirmPasswordPanel.getPassword();
    }

    public void showError(String message) {
        errorPanel.setIconLabel("src/assets/icon-error.png");
        errorPanel.setMessageLabel(message);
    }
}
