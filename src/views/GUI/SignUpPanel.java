package views.GUI;

import views.customPalettes.RoundedButton;
import views.customPalettes.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class SignUpPanel extends JPanel {
    private final Color shadowColor = new Color(0, 0, 0, 90);

    public SignUpPanel() {
        setLayout(new GridLayout(3, 2, 10, 10)); // Set layout for the panel

        // Create and add text fields
        TextField textFieldUsername = new TextField("Username", new Dimension(200, 42));
        TextField passwordField = new TextField("Password", new Dimension(200, 42));
        add(textFieldUsername);
        add(passwordField);

        // Create and add rounded buttons
        RoundedButton button1 = new RoundedButton("Button 1", 130, 42, Color.decode("#E5D1D2"));
        RoundedButton button2 = new RoundedButton("Button 2", 130, 42, Color.decode("#E4C988"));
        add(button1);
        add(button2);

        setOpaque(false); // Make the panel transparent
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow border
        g2d.setColor(shadowColor);
        g2d.fill(new RoundRectangle2D.Float(3, 3, getWidth() - 6, getHeight() - 6, 17, 17));

        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign Up Panel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        SignUpPanel signUpPanel = new SignUpPanel();
        frame.add(signUpPanel, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


