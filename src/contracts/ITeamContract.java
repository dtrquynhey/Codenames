package contracts;

import models.Player;
import models.enums.Color;
import models.enums.Role;

import java.util.List;
import java.util.Map;

public interface ITeamContract {

    boolean isValidRoom(String[] players);
     void randomizeRolesAndTeams(List<Player> players);
}
