package views.uihelpers;

import views.gui.LoginUI;
import views.gui.RulesUI;

public class UIManager {

    public static void openRulesUI() {
        RulesUI ruleUI = new RulesUI();
        ruleUI.setVisible(true);
    }

    public static void openLoginUI() {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }
}
