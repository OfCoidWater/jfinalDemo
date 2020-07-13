package bean;


import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

public class Permission extends Model<Permission> {
    public static Permission dao = new Permission().dao();
    @Setter @Getter private int permissionId;
    @Setter @Getter private String permissionName;

}
