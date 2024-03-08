package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;

public class RulesUI extends Frame {

    public RulesUI() {
        super(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblComingSoon = new ShadowLabel("This feature is coming soon...");
        lblComingSoon.setFont(new Font("Cambria", Font.BOLD, 25));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 0, 20, 0);
        panel.add(lblComingSoon, gridBagConstraints);

        this.setVisible(true);

    }

    public static void main(String[] args) {

        new RulesUI();
    }
}
