package views.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private LoginPanel loginPanel;
    private SignupPanel signupPanel;
    private WelcomePanel welcomePanel;
    private RulesPanel rulesPanel;

    public MainFrame() {
        super("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon.jpeg").getImage());
        setSize(1280, 800);
        setBackground(Color.decode("#43766C"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initializePanels();
        showRulesPanel();

        setVisible(true);
    }


    private void initializePanels() {
        loginPanel = new LoginPanel();
        signupPanel = new SignupPanel();
        welcomePanel = new WelcomePanel();
        rulesPanel = new RulesPanel();
    }


    private void showLoginPanel() {
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }

    private void showSignupPanel() {
        setContentPane(signupPanel);
        revalidate();
        repaint();
    }

    private void showWelcomePanel() {
        setContentPane(welcomePanel);
        revalidate();
        repaint();
    }

    private void showRulesPanel() {
        setContentPane(rulesPanel);
        revalidate();
        repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
