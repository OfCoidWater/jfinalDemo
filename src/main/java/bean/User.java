package bean;

import com.jfinal.plugin.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@ToString(exclude = "id" )
public class User extends Model<User> {
    public static final User dao = new User().dao();
    @Getter @Setter private String name;
    @Getter @Setter private String password;
    @Getter @Setter private Date creatTime;
    @Getter @Setter private int id;
}
