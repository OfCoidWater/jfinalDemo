import bean.Permission;
import bean.Role;
import bean.User;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import org.junit.Before;
import org.junit.Test;
import service.impl.UserServiceImpl;

import java.util.List;

public class Demo1 {
    //测试lombok依赖是否成功注入
    //测试jfinal的aop

    @Test
    public void test2(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.queryUserByName("admin");
        System.out.println(user);
    }
}
