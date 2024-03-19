package views.customPalettes;

import models.enums.Color;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RolesChooserPanel extends JPanel {

    private final OneRoleChooserPanel spymasterRedRoleChooser;
    private final OneRoleChooserPanel spymasterBlueRoleChooser;
    private final OneRoleChooserPanel operativeRedRoleChooser;
    private final OneRoleChooserPanel operativeBlueRoleChooser;


     public RolesChooserPanel(String[] playerNicknames) {
         setLayout(new BorderLayout());
         setBackground(CustomColor.BROWN.getColor());
         ContainerPanel containerPanel = new ContainerPanel(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(850, 515));

         add(containerPanel, BorderLayout.CENTER);

         containerPanel.setLayout(new GridBagLayout());
         GridBagConstraints gridBagConstraints = new GridBagConstraints();

         Label labelRed = new Label(Color.RED.toString(), Font.BOLD, 32, CustomColor.TITLE.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(labelRed, gridBagConstraints);

         Label labelBlue = new Label(Color.BLUE.toString(), Font.BOLD, 32, CustomColor.TITLE.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(labelBlue, gridBagConstraints);

         Label labelOperatives = new Label(Role.SPYMASTER.toString(), Font.BOLD, 32, CustomColor.TITLE.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(labelOperatives, gridBagConstraints);

         Label labelSpymasters = new Label(Role.OPERATIVE.toString(), Font.BOLD, 32, CustomColor.TITLE.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(labelSpymasters, gridBagConstraints);

         spymasterRedRoleChooser = new OneRoleChooserPanel(playerNicknames, playerNicknames[0], "src/assets/spymaster-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 10);
         containerPanel.add(spymasterRedRoleChooser, gridBagConstraints);

         spymasterBlueRoleChooser = new OneRoleChooserPanel(playerNicknames, playerNicknames[1], "src/assets/spymaster-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(spymasterBlueRoleChooser, gridBagConstraints);

         operativeRedRoleChooser = new OneRoleChooserPanel(playerNicknames, playerNicknames[2], "src/assets/operative-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(operativeRedRoleChooser, gridBagConstraints);

         operativeBlueRoleChooser = new OneRoleChooserPanel(playerNicknames, playerNicknames[3], "src/assets/operative-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 0);
         containerPanel.add(operativeBlueRoleChooser, gridBagConstraints);
     }

    public String[] getSelectedPlayers() {
        String[] selectedPlayers = new String[4];
        OneRoleChooserPanel[] panels = {spymasterRedRoleChooser, spymasterBlueRoleChooser, operativeRedRoleChooser, operativeBlueRoleChooser};
        for (int i = 0; i < panels.length; i++) {
            selectedPlayers[i] = panels[i].getSelectedPlayer();
        }
        return selectedPlayers;
    }


    public Map<Color, Map<Role, String>> getPlayerSelectedTeams() {
        Map<Color, Map<Role, String>> playerSelectedRoles = new HashMap<>();

        playerSelectedRoles.put(Color.RED, getPlayerSelectedRoles(spymasterRedRoleChooser.getSelectedPlayer(), operativeRedRoleChooser.getSelectedPlayer()));
        playerSelectedRoles.put(Color.BLUE, getPlayerSelectedRoles(spymasterBlueRoleChooser.getSelectedPlayer(), operativeBlueRoleChooser.getSelectedPlayer()));

        return playerSelectedRoles;
    }

    private Map<Role, String> getPlayerSelectedRoles(String spymaster, String operative) {
        Map<Role, String> playerRoles = new HashMap<>();
        playerRoles.put(Role.SPYMASTER, spymaster);
        playerRoles.put(Role.OPERATIVE, operative);
        return playerRoles;
    }


}
