package views.customPalettes;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    protected JPanel panel;
    protected TopFlowPanel topFlowPanel;
    protected CenterGridBagPanel centerGridBagPanel;


    public Frame() {
        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        topFlowPanel = new TopFlowPanel();
        centerGridBagPanel = new CenterGridBagPanel();

        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#43766C"));

        topFlowPanel = new TopFlowPanel();
        panel.add(topFlowPanel, BorderLayout.NORTH);
        panel.add(centerGridBagPanel, BorderLayout.CENTER);

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
