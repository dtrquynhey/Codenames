package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class MessageDialog extends JDialog {
    public MessageDialog(Component parentComponent, String message, String title) {
        super((Frame) SwingUtilities.getWindowAncestor(parentComponent), title, true);
        getContentPane().setBackground(CustomColor.BROWN.getColor());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(CustomColor.BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label messageLabel = new Label(message, Font.PLAIN, 16, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 0, 30);
        panel.add(messageLabel, gridBagConstraints);

        RoundedButton buttonOk = new RoundedButton("OK", 90, 42, CustomColor.RED.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 30, 30, 30);
        panel.add(buttonOk, gridBagConstraints);

        buttonOk.addActionListener(e -> dispose());

        add(panel);
        pack();
        setLocationRelativeTo(parentComponent);
        setVisible(true);
    }
}
