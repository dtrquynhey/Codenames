package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class IconLabelPanel extends JPanel {

    private final JLabel iconLabel;

    private final Label label;

    public IconLabelPanel(String text) {
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#D32424"));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        iconLabel = new JLabel(new ImageIcon());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(iconLabel, gridBagConstraints);

        label = new Label(text, Font.PLAIN, 16, Color.WHITE.darker());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(label, gridBagConstraints);
    }

    public void setMessageLabel(String text) {
        label.setText(text);
    }
    public void setIconLabel(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        iconLabel.setIcon(icon);
    }
}
