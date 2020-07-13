package bean;

import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

public class Role extends Model<Role> {
    public static final Role dao = new Role().dao();
    @Setter @Getter private int roleId;
    @Setter @Getter private String roleName;
}
