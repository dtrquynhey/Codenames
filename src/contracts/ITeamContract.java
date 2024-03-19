package contracts;

import models.enums.Color;
import models.enums.Role;

import java.util.Map;

public interface ITeamContract {

    void setupTeams(Map<Color, Map<Role, String>> playerSelectedTeams);

    boolean isValidRoom(String[] players);
}
