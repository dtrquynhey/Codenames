package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class TopFlowPanel extends JPanel {

    public TopFlowPanel() {
        setBackground(CustomColor.FRAME.getColor());
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }
}
