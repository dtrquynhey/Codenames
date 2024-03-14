package views.gui;

import views.customPalettes.ContainerPanel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class SetupPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SetupPanel::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create a JFrame
        JFrame frame = new JFrame("ContainerPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create an instance of ContainerPanel
        ContainerPanel containerPanel = new ContainerPanel(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(200, 200));

        // Add ContainerPanel to the JFrame
        frame.add(containerPanel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
