package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class MessageDialog extends JDialog {

    private Label messageLabel;

    public MessageDialog(Component parentComponent, String message, String title, String button) {
        super((Frame) SwingUtilities.getWindowAncestor(parentComponent), title, true);
        initializeDialog(parentComponent, message, button);
    }

    private void initializeDialog(Component parentComponent, String message, String button1Text) {
        getContentPane().setBackground(CustomColor.FRAME.getColor());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(CustomColor.FRAME.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        messageLabel = new Label(message, Font.PLAIN, 16, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 0, 30);
        panel.add(messageLabel, gridBagConstraints);

        RoundedButton buttonOk = new RoundedButton(button1Text, 142, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 30, 10, 30);
        panel.add(buttonOk, gridBagConstraints);

        buttonOk.addActionListener(e -> {
            dispose();
        });

        add(panel);
        pack();
        setLocationRelativeTo(parentComponent);
        setVisible(true);
    }

    // Getter method to set messageLabel font style to Font.BOLD
    public void setMessageLabelBold() {
        if (messageLabel != null) {
            Font currentFont = messageLabel.getFont();
            Font boldFont = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
            messageLabel.setFont(boldFont);
        }
    }
}
