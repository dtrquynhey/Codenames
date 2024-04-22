package views.gui;

import controllers.PlayerController;
import controllers.AccountController;
import repositories.DbConfig;
import repositories.AccountRepository;
import views.customPalettes.PopupFrame;

import javax.swing.*;
import java.sql.Connection;

public class MainFrame extends JFrame {
    private final AccountController accountController;
    private final PlayerController playerController;

    private JPanel currentPanel;
    private JPanel previousPanel;

    private MainPanel mainPanel;
    private RulesPanel rulesPanel;

    public MainFrame(){
        super("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon-app.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        accountController = AccountController.getInstance();
        playerController = PlayerController.getInstance();
        initializePanels();
        setContentPane(mainPanel);

        setVisible(true);
    }


    private void initializePanels() {
        mainPanel = new MainPanel(accountController);
        rulesPanel = new RulesPanel();
    }

    public void showPanel(JPanel panel) {
        previousPanel = currentPanel; // Store the current panel as the previous panel
        currentPanel = panel; // Set the current panel to the new panel
        setContentPane(currentPanel);
        setSize(1280, 800);
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    public void showPopupPanel(JPanel panel) {
        previousPanel = currentPanel;
        PopupFrame popupFrame = new PopupFrame();
        popupFrame.setContentPane(panel);
    }

    public void showMainPanel() {
        mainPanel = new MainPanel(new AccountController());
        showPanel(mainPanel);
    }

    public void showSignupPanel() {
        showPopupPanel(new SignupPanel(accountController));
    }
    public void showLoginPanel() {
        showPopupPanel(new LoginPanel(accountController));
    }

    public void showRulesPanel() {
        showPopupPanel(rulesPanel);
    }



    public void goBack() {
        if (previousPanel != null) {
            showPanel(previousPanel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
