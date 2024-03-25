package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class BottomFlowPanel extends JPanel {

    public BottomFlowPanel() {
        setBackground(CustomColor.FRAME_GREEN.getColor());
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }
}
