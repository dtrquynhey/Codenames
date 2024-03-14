import views.customPalettes.ContainerPanel;
import views.customPalettes.Label;
import views.customPalettes.TextField;
import views.customPalettes.TextFieldPanel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.security.DigestException;

public class PlayersNamePanel extends JPanel {

    public PlayersNamePanel(Color bgColor, Dimension dimension) {
        setLayout(new GridBagLayout());

        ContainerPanel containerPanel = new ContainerPanel(bgColor, dimension);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(containerPanel, gridBagConstraints); // Add containerPanel with constraints


        GridBagLayout containerGridBagLayout = new GridBagLayout();
        containerPanel.setLayout(containerGridBagLayout);
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();

        Label labelEnterPlayer = new Label("Enter players' nickname.", Font.BOLD, 16, CustomColor.TITLE.getColor());
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.insets = new Insets(15, 0, 0, 0);
        containerPanel.add(labelEnterPlayer, gridBagConstraints1);

        TextField player1TextField = new TextField("Player 1", new Dimension(200, 42));
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 1;
        gridBagConstraints1.insets = new Insets(10, 0, 0, 0);
        containerPanel.add(player1TextField, gridBagConstraints1);

        TextField player2TextField = new TextField("Player 2", new Dimension(200, 42));
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 2;
        gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
        containerPanel.add(player2TextField, gridBagConstraints1);

        TextField player3TextField = new TextField("Player 3", new Dimension(200, 42));
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
        containerPanel.add(player3TextField, gridBagConstraints1);

        TextField player4TextField = new TextField("Player 4", new Dimension(200, 42));
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.gridy = 4;
        gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
        containerPanel.add(player4TextField, gridBagConstraints1);


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Players Name Panel Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PlayersNamePanel playersNamePanel = new PlayersNamePanel(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(360, 280));

            frame.add(playersNamePanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
