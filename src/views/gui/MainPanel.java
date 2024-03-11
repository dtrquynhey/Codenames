package views.gui;

import views.customPalettes.BottomFlowPanel;
import views.customPalettes.CenterGridBagPanel;
import views.customPalettes.TopFlowPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    protected TopFlowPanel topFlowPanel;
    protected CenterGridBagPanel centerGridBagPanel;
    protected BottomFlowPanel bottomFlowPanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#43766C"));

        topFlowPanel = new TopFlowPanel();
        centerGridBagPanel = new CenterGridBagPanel();
        bottomFlowPanel = new BottomFlowPanel();

        add(topFlowPanel, BorderLayout.NORTH);
        add(centerGridBagPanel, BorderLayout.CENTER);
        add(bottomFlowPanel, BorderLayout.SOUTH);
    }
}
