package views.customPalettes;

import views.customPalettes.BottomFlowPanel;
import views.customPalettes.CenterGridBagPanel;
import views.customPalettes.TopFlowPanel;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    protected TopFlowPanel topFlowPanel;
    protected CenterGridBagPanel centerGridBagPanel;
    protected BottomFlowPanel bottomFlowPanel;

    public Panel() {
        setLayout(new BorderLayout());

        topFlowPanel = new TopFlowPanel();
        centerGridBagPanel = new CenterGridBagPanel();
        bottomFlowPanel = new BottomFlowPanel();

        add(topFlowPanel, BorderLayout.NORTH);
        add(centerGridBagPanel, BorderLayout.CENTER);
        add(bottomFlowPanel, BorderLayout.SOUTH);
    }

    public void setPanelsBackgroundColor(Color color) {
        topFlowPanel.setBackground(color);
        centerGridBagPanel.setBackground(color);
        bottomFlowPanel.setBackground(color);
    }
}
