package views.gui;

import views.customPalettes.CustomColor;
import views.customPalettes.Label;
import views.customPalettes.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class RulesPanel extends MainPanel {

    public RulesPanel() {
        super();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label lblComingSoon = new Label("This feature is coming soon!", Font.PLAIN, 16 , Color.WHITE );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(lblComingSoon, gridBagConstraints);

        RoundedButton buttonGoBack = new RoundedButton("Go Back", 115, 42, CustomColor.RED.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 4, 0);
        centerGridBagPanel.add(buttonGoBack, gridBagConstraints);

        buttonGoBack.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(RulesPanel.this);
            mainFrame.goBack();
        });

        this.setVisible(true);

    }
}
