package views.gui;

import controllers.AccountController;
import views.customPalettes.PopupFrame;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JPanel currentPanel;
    private JPanel previousPanel;

    private MainPanel mainPanel;

    public MainFrame(){
        super("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon-app.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        initializePanels();
        setContentPane(mainPanel);

        setVisible(true);
    }


    private void initializePanels() {
        mainPanel = new MainPanel(new AccountController());
    }

    public void showPanel(JPanel panel) {
        previousPanel = currentPanel;
        currentPanel = panel;
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
        mainPanel = new MainPanel(AccountController.getInstance());
        showPanel(mainPanel);
    }

    public void showSignupPanel() {
        showPopupPanel(new SignupPanel(AccountController.getInstance()));
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
