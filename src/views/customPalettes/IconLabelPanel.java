package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class IconLabelPanel extends JPanel {
    private Label label;

    public IconLabelPanel(String text) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel imageLabel = new JLabel(new ImageIcon("src/assets/icon-error.png"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(imageLabel, gridBagConstraints);

        label = new Label(text, Font.PLAIN, 16, Color.WHITE.darker());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(label, gridBagConstraints);
    }

    public void setText(String text) {
        label.setText(text);
    }
}
