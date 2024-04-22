package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class CenterGridBagPanel extends JPanel {

    public CenterGridBagPanel() {
        setBackground(CustomColor.FRAME.getColor());
        setLayout(new GridBagLayout());
    }
}
