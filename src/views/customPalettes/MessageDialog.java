package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MessageDialog extends JDialog {
    private final ButtonCancelListener buttonCancelListener;

    public MessageDialog(Component parentComponent, String message, String title, String button) {
        super((Frame) SwingUtilities.getWindowAncestor(parentComponent), title, true);
        this.buttonCancelListener = null;
        initializeDialog(parentComponent, message, button, null);
    }

    public MessageDialog(Component parentComponent, String message, String title, String button1Text, String button2Text, ButtonCancelListener buttonCancelListener) {
        super((Frame) SwingUtilities.getWindowAncestor(parentComponent), title, true);
        this.buttonCancelListener = buttonCancelListener;
        initializeDialog(parentComponent, message, button1Text, button2Text);
    }

    private void initializeDialog(Component parentComponent, String message, String button1Text, String button2Text) {
        getContentPane().setBackground(CustomColor.FRAME.getColor());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(CustomColor.FRAME.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label messageLabel = new Label(message, Font.PLAIN, 16, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 0, 30);
        panel.add(messageLabel, gridBagConstraints);

        RoundedButton buttonOk = new RoundedButton(button1Text, 90, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 30, 10, 30); // Changed insets to make space between buttons
        panel.add(buttonOk, gridBagConstraints);

        buttonOk.addActionListener(e -> {
            dispose();
        });

        if (button2Text != null) {
            RoundedButton buttonCancel = new RoundedButton(button2Text, 90, 42, CustomColor.RED.getColor());
            gridBagConstraints.gridy = 2; // Set gridy to add the second button below the first one
            gridBagConstraints.insets = new Insets(10, 30, 30, 30);
            panel.add(buttonCancel, gridBagConstraints);

            buttonCancel.addActionListener(e -> {
                buttonCancelListener.onButtonCancel();
            });
        }

        add(panel);
        pack();
        setLocationRelativeTo(parentComponent);
        setVisible(true);
    }

    public interface ButtonCancelListener {

        void onButtonCancel();
    }
}
