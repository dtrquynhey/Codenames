package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class CenterGridBagPanel extends JPanel {

    public CenterGridBagPanel() {
        setBackground(Color.decode("#43766C"));
        setLayout(new GridBagLayout());
    }

    public void addComponent(Component component, GridBagConstraints constraints) {
        add(component, constraints);
    }
}
