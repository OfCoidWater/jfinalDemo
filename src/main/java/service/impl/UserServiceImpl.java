package service.impl;

import bean.Permission;
import bean.Role;
import bean.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Override
    public boolean online(String name, String password) {
        return false;
    }

    @Override
    public User queryUserByName(String name){
        String sql = "select id,name,password,creat_time as creatTime from `user` where name = ?" ;
        User user = null;
            user = User.dao.findFirst(sql,name);
        return user;
    }

    @Override
    public List<Role> queryRoleByUserId(int userId) {
        String sql = "select * from role r inner join user_role ur on(r.role_id = ur.role_id) " +
                "where ur.user_id = ?";
        List<Role> roles = Role.dao.find(sql,userId);
        for (Role role: roles) {
            String role_name = role.getStr("role_name");
        }
        return null;
    }

    @Override
    public List<Permission> queryPermissionByUserId(int userId) {
        return null;
    }

    @Override
    public List queryUsers() {
        List<Record> list = Db.find("select * from user");
        return list;
    }
}
