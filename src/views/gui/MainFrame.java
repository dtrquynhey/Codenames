package views.gui;

import controllers.PlayerController;
import controllers.AccountController;
import repositories.DbConfig;
import repositories.PlayerRepository;
import repositories.AccountRepository;
import repositories.mappers.PlayerMapper;
import repositories.mappers.AccountMapper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private final AccountController accountController;
    private final PlayerController playerController;

    private JPanel currentPanel;
    private JPanel previousPanel;

    private LoginPanel loginPanel;
    private SignupPanel signupPanel;
    private RoomCreationPanel roomCreationPanel;
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
        AccountMapper accountMapper = new AccountMapper();
        PlayerMapper playerMapper = new PlayerMapper();
        AccountRepository accountRepository = new AccountRepository(connection, accountMapper);
        PlayerRepository playerRepository = new PlayerRepository(connection, playerMapper);
        accountController = AccountController.getInstance(accountRepository);
        playerController = PlayerController.getInstance();
        initializePanels();
        showLoginPanel();

        setVisible(true);
    }


    private void initializePanels() {
        loginPanel = new LoginPanel(accountController);
        signupPanel = new SignupPanel(accountController);
        roomCreationPanel = new RoomCreationPanel(playerController);
        rulesPanel = new RulesPanel();
    }

    public void showPanel(JPanel panel) {
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

    public void showRoomCreationPanel() {
        showPanel(roomCreationPanel);
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
