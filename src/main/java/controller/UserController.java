package controller;

import bean.User;
import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.sun.deploy.net.HttpRequest;
import jdk.nashorn.internal.ir.annotations.Ignore;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.xml.ws.Service;
import java.util.List;

public class UserController extends Controller {
    @Inject(UserServiceImpl.class)
    UserService userService;

    public void index(){
        renderText("hello");
    }
    public void add(){
        System.out.println("进入添加方法");
        boolean save = new User().set("name", "zhangsan").set("password", "123456").save();
        if (save) renderText("添加失败");
        renderText("添加成功");
    }
    public void query(){
        userService.queryRoleByUserId(1);
    }
    public void blog(){
        User user = getBean(User.class,"");
        renderText(user.toString());
    }
    public void queryUser(){
        render("/WEB-INF/1.html");
    }
}
