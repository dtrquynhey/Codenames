package views.customPalettes;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    protected JPanel panel;
    protected TopFlowPanel topFlowPanel;


    public Frame(LayoutManager layoutManager) {
        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        topFlowPanel = new TopFlowPanel();

        panel = new JPanel(layoutManager);
        panel.setBackground(Color.decode("#43766C"));

        panel.add(topFlowPanel, BorderLayout.NORTH);

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame(new GridLayout());
    }
}
