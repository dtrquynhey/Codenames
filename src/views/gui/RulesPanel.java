package views.gui;

import views.customPalettes.Panel;
import views.customPalettes.Label;

import java.awt.*;

public class RulesPanel extends Panel {

    public RulesPanel() {
        super();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        Label lblComingSoon = new Label("This feature is coming soon!", Font.PLAIN, 16 , Color.WHITE );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(lblComingSoon, gridBagConstraints);

        this.setVisible(true);

    }
}
