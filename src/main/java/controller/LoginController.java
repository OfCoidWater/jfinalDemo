package controller;

import bean.ActivierUser;
import bean.User;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import service.UserService;
import service.impl.UserServiceImpl;
public class LoginController extends Controller {
    @Inject(UserServiceImpl.class)
    UserService userService;
    public void login(String name, String password){
/*        User user = userService.queryUserByName(name);
        if (null!=user) {
            String verifyPassword = user.getStr("password");
            if (!password.equals(verifyPassword))
                renderText("密码错误");
        }else {
            renderText("用户名错误");
        }
        render("/WEB-INF/1.html");*/
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            renderText("登陆成功");
        }catch (AuthenticationException e){
            renderText("用户名密码错误");
        }
    }

    public void hello(){
        User user = userService.queryUserByName("admin");
        renderText(user.toString());
    }
    public void toRegister(){
        render("/WEB-INF/register.html");
    }
    public void toLogin(){
        render("/WEB-INF/login.html");
    }
}
