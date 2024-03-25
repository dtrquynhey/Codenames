package views.gui;

import views.customPalettes.Label;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressDialog extends JDialog {
    private static final int DURATION_MS = 3000;

    public ProgressDialog(Frame parent, String title, boolean modal) {
        super(parent, title, modal);

        initComponents();
        scheduleClose(); // Schedule the dialog to close after a duration
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Show an indeterminate loading spinner
        progressBar.setPreferredSize(new Dimension(100, 5));
        progressBar.setBackground(CustomColor.ORANGE.getColor());
        progressBar.setForeground(CustomColor.TEXT_BG_GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        add(progressBar, gridBagConstraints);

        Label label = new Label("Creating new room in progress...", Font.BOLD, 14, CustomColor.TEXT_WHITE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        add(label, gridBagConstraints);

        // Set dialog properties
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Prevent closing the dialog
        setPreferredSize(new Dimension(500, 200));
        setLocationRelativeTo(getParent()); // Center the dialog on the parent frame
        pack();
    }

    private void scheduleClose() {
        Timer timer = new Timer(DURATION_MS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the dialog when the timer expires
                dispose();
            }
        });
        timer.setRepeats(false); // Do not repeat the timer
        timer.start(); // Start the timer
    }

    public static void main(String[] args) {
        // Create a frame as the parent component
        JFrame frame = new JFrame("ProgressDialog Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 500);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create a button to trigger the dialog
        JButton button = new JButton("Show ProgressDialog");
        button.addActionListener(e -> {
            ProgressDialog dialog = new ProgressDialog(frame, "Loading", true);
            dialog.setVisible(true);
        });

        // Add the button to the frame
        frame.add(button, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}
