package models;

import models.enums.Role;

public class Player extends User {
    private Role role;

    public Player(Role role) {
        this.role = role;
    }

    public Player(String username, String password, Role role) {
        super(username, password);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
