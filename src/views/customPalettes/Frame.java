package views.customPalettes;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    protected JPanel panel;
    protected TopFlowPanel topFlowPanel;
    protected CenterGridBagPanel centerGridBagPanel;
    protected BottomFlowPanel bottomFlowPanel;


    public Frame() {
        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon.jpeg").getImage());
        setSize(1280, 800);
        setBackground(Color.decode("#43766C"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel(new BorderLayout());

        topFlowPanel = new TopFlowPanel();
        centerGridBagPanel = new CenterGridBagPanel();
        bottomFlowPanel = new BottomFlowPanel();

        panel.add(topFlowPanel, BorderLayout.NORTH);
        panel.add(centerGridBagPanel, BorderLayout.CENTER);
        panel.add(bottomFlowPanel, BorderLayout.SOUTH);

        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
