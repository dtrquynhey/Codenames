package views.gui;

import controllers.UserController;
import repositories.DbConfig;
import repositories.UserRepository;
import repositories.mappers.UserMapper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private final UserController userController;

    private JPanel currentPanel;
    private JPanel previousPanel;

    private LoginPanel loginPanel;
    private SignupPanel signupPanel;
    private WelcomePanel welcomePanel;
    private RulesPanel rulesPanel;

    public MainFrame(){
        super("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon-app.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Connection connection;
        try {
            connection = DbConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UserMapper userMapper = new UserMapper();
        UserRepository userRepository = new UserRepository(connection, userMapper);

        userController = UserController.getInstance(userRepository);

        initializePanels();
        showLoginPanel();

        setVisible(true);
    }


    private void initializePanels() {
        loginPanel = new LoginPanel(userController);
        signupPanel = new SignupPanel(userController);
        welcomePanel = new WelcomePanel();
        rulesPanel = new RulesPanel();
    }

    private void showPanel(JPanel panel) {
        previousPanel = currentPanel; // Store the current panel as the previous panel
        currentPanel = panel; // Set the current panel to the new panel
        setContentPane(currentPanel);
        revalidate();
        repaint();
    }

    public void showLoginPanel() {
        showPanel(loginPanel);
    }

    public void showSignupPanel() {
        showPanel(signupPanel);
    }

    public void showWelcomePanel() {
        showPanel(welcomePanel);
    }

    public void showRulesPanel() {
        showPanel(rulesPanel);
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
