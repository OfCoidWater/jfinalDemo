package service;

import bean.Permission;
import bean.Role;
import bean.User;

import java.util.List;

public interface UserService {
    boolean online(String name,String password);
    User queryUserByName(String name);
    //根据用户Id查询角色
    List<Role> queryRoleByUserId(int userId);
    //根据用户Id查询权限
    List<Permission> queryPermissionByUserId(int userId);

    //查询用户列表
    List queryUsers();
}
