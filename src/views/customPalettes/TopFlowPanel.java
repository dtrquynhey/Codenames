package views.customPalettes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TopFlowPanel extends JPanel {

    private ArrayList<RoundedButton> buttons;
    public TopFlowPanel() {
        buttons = new ArrayList<>();
        setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    public void addButton(RoundedButton button) {
        buttons.add(button);
        add(button);
    }

    public ArrayList<RoundedButton> getButtons() {
        return buttons;
    }
}