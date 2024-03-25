package views.customPalettes;

import models.Player;
import models.enums.Color;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolesChooserPanel extends JPanel {

    private final OneRoleChooserPanel spymasterRedRoleChooser;
    private final OneRoleChooserPanel spymasterBlueRoleChooser;
    private final OneRoleChooserPanel operativeRedRoleChooser;
    private final OneRoleChooserPanel operativeBlueRoleChooser;

    private List<Player> playerList;

     public RolesChooserPanel(List<Player> playerList) {
         this.playerList = playerList;
         setLayout(new BorderLayout());
         setBackground(new java.awt.Color(0, 0, 0, 0));

         ContainerPanel containerPanel = new ContainerPanel(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(850, 515));

         add(containerPanel, BorderLayout.CENTER);

         containerPanel.setLayout(new GridBagLayout());
         GridBagConstraints gridBagConstraints = new GridBagConstraints();

         Label labelRed = new Label(Color.RED.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(labelRed, gridBagConstraints);

         Label labelBlue = new Label(Color.BLUE.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(labelBlue, gridBagConstraints);

         Label labelOperatives = new Label(Role.SPYMASTER.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(labelOperatives, gridBagConstraints);

         Label labelSpymasters = new Label(Role.OPERATIVE.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(labelSpymasters, gridBagConstraints);

         spymasterRedRoleChooser = new OneRoleChooserPanel(playerList, playerList.getFirst().getNickname(), "src/assets/spymaster-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 10);
         containerPanel.add(spymasterRedRoleChooser, gridBagConstraints);

         spymasterBlueRoleChooser = new OneRoleChooserPanel(playerList, playerList.get(1).getNickname(), "src/assets/spymaster-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         containerPanel.add(spymasterBlueRoleChooser, gridBagConstraints);

         operativeRedRoleChooser = new OneRoleChooserPanel(playerList, playerList.get(2).getNickname(), "src/assets/operative-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         containerPanel.add(operativeRedRoleChooser, gridBagConstraints);

         operativeBlueRoleChooser = new OneRoleChooserPanel(playerList, playerList.get(3).getNickname(), "src/assets/operative-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 0);
         containerPanel.add(operativeBlueRoleChooser, gridBagConstraints);
     }

    public String[] getComboBoxSelectedPlayers() {
        String[] selectedPlayers = new String[4];
        OneRoleChooserPanel[] panels = {spymasterRedRoleChooser, spymasterBlueRoleChooser, operativeRedRoleChooser, operativeBlueRoleChooser};
        for (int i = 0; i < panels.length; i++) {
            selectedPlayers[i] = panels[i].getSelectedPlayer().getNickname();
        }
        return selectedPlayers;
    }


    public Map<Color, Map<Role, Player>> getPlayerSelectedTeams() {
        Map<Color, Map<Role, Player>> playerSelectedTeams = new HashMap<>();

        playerSelectedTeams.put(Color.RED, getPlayerSelectedRoles(spymasterRedRoleChooser.getSelectedPlayer(), operativeRedRoleChooser.getSelectedPlayer()));
        playerSelectedTeams.put(Color.BLUE, getPlayerSelectedRoles(spymasterBlueRoleChooser.getSelectedPlayer(), operativeBlueRoleChooser.getSelectedPlayer()));

        return playerSelectedTeams;
    }

    private Map<Role, Player> getPlayerSelectedRoles(Player spymaster, Player operative) {
        Map<Role, Player> playerRoles = new HashMap<>();
        playerRoles.put(Role.SPYMASTER, spymaster);
        playerRoles.put(Role.OPERATIVE, operative);
        return playerRoles;
    }


}
