package bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ActivierUser {
    @Setter @Getter private User user;
    @Setter @Getter private List<Role> roles;
    @Setter @Getter private List<Permission> permissions;

    public ActivierUser() {
    }
    public ActivierUser(User user, List<Role> roles, List<Permission> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }
}
