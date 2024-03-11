package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class TopFlowPanel extends JPanel {

    public TopFlowPanel() {
        setBackground(CustomColor.BROWN.getColor());
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
    }
}
