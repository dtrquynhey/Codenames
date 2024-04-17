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

     public RolesChooserPanel(List<Player> players) {
         setBackground(new java.awt.Color(0, 0, 0, 0));

         //ContainerPanel containerPanel = new ContainerPanel(CustomColor.CONTAINER_BROWN.getColor(), new Dimension(850, 515));

         //add(containerPanel, BorderLayout.CENTER);

         setLayout(new GridBagLayout());
         GridBagConstraints gridBagConstraints = new GridBagConstraints();

         Label labelRed = new Label(Color.RED.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         add(labelRed, gridBagConstraints);

         Label labelBlue = new Label(Color.BLUE.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         add(labelBlue, gridBagConstraints);

         Label labelOperatives = new Label(Role.SPYMASTER.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         add(labelOperatives, gridBagConstraints);

         Label labelSpymasters = new Label(Role.OPERATIVE.toString(), Font.BOLD, 32, CustomColor.TEXT.getColor());
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         add(labelSpymasters, gridBagConstraints);

         spymasterRedRoleChooser = new OneRoleChooserPanel(players, players.getFirst().getNickname(), "src/assets/spymaster-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 10);
         add(spymasterRedRoleChooser, gridBagConstraints);

         spymasterBlueRoleChooser = new OneRoleChooserPanel(players, players.get(1).getNickname(), "src/assets/spymaster-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.insets = new Insets(0, 0, 10, 0);
         add(spymasterBlueRoleChooser, gridBagConstraints);

         operativeRedRoleChooser = new OneRoleChooserPanel(players, players.get(2).getNickname(), "src/assets/operative-red.png", CustomColor.RED_COMBOBOX.getColor());
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 10);
         add(operativeRedRoleChooser, gridBagConstraints);

         operativeBlueRoleChooser = new OneRoleChooserPanel(players, players.get(3).getNickname(), "src/assets/operative-blue.png", CustomColor.BLUE_COMBOBOX.getColor());
         gridBagConstraints.gridx = 2;
         gridBagConstraints.gridy = 2;
         gridBagConstraints.insets = new Insets(0, 0, 0, 0);
         add(operativeBlueRoleChooser, gridBagConstraints);
     }

    public String[] getComboBoxSelectedPlayers() {
        String[] selectedPlayers = new String[4];
        OneRoleChooserPanel[] panels = {spymasterRedRoleChooser, spymasterBlueRoleChooser, operativeRedRoleChooser, operativeBlueRoleChooser};
        for (int i = 0; i < panels.length; i++) {
            selectedPlayers[i] = panels[i].getSelectedPlayer().getNickname();
        }
        return selectedPlayers;
    }


    public Map<Color, Map<Role, Player>> getPlayerSelectedTeamsMap() {
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

    public void updateRoleChoosers(Map<Color, Map<Role, Player>> playerSelectedTeams) {
        spymasterRedRoleChooser.setSelectedPlayer(playerSelectedTeams.get(Color.RED).get(Role.SPYMASTER));
        operativeRedRoleChooser.setSelectedPlayer(playerSelectedTeams.get(Color.RED).get(Role.OPERATIVE));
        spymasterBlueRoleChooser.setSelectedPlayer(playerSelectedTeams.get(Color.BLUE).get(Role.SPYMASTER));
        operativeBlueRoleChooser.setSelectedPlayer(playerSelectedTeams.get(Color.BLUE).get(Role.OPERATIVE));
    }




}
