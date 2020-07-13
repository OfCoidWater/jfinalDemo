package config;

import bean.Permission;
import bean.Role;
import bean.User;

import com.jfinal.config.*;
import com.jfinal.json.JacksonFactory;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import controller.LoginController;
import controller.UserController;
import org.apache.shiro.web.servlet.ShiroFilter;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class MyConfig extends JFinalConfig {
    Routes me = null;
    //常量
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        constants.setEncoding("UTF-8");
        // 开启对 jfinal web 项目组件 Controller、Interceptor、Validator 的注入
        constants.setInjectDependency(true);
        constants.setJsonFactory(new JacksonFactory());
        //开启对超类的注入。不开启时可以在超类中通过 Aop.get(...) 进行注入
        constants.setInjectSuperClass(true);
    }
    //路由
    @Override
    public void configRoute(Routes routes) {
        routes.setMappingSuperClass(true);
        routes.add("/user",UserController.class);
        routes.add("/login",LoginController.class);
        me = routes;
    }
    //引擎
    @Override
    public void configEngine(Engine engine) {
    }
    //插件
    @Override
    public void configPlugin(Plugins plugins) {
        DruidPlugin druidPlugin = new DruidPlugin("jdbc:mysql://localhost:3306/my_shro",
                "root", "123456","com.mysql.jdbc.Driver");
        plugins.add(druidPlugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        plugins.add(activeRecordPlugin);
        activeRecordPlugin.addMapping("user",User.class);
        activeRecordPlugin.addMapping("role","role_id",Role.class);
        activeRecordPlugin.addMapping("permission","permission_id",Permission.class);
        ShiroPlugin shiroPlugin = new ShiroPlugin(me);
    }
    //拦截器
    @Override
    public void configInterceptor(Interceptors interceptors) {
    }
    //处理器
    @Override
    public void configHandler(Handlers handlers) {
    }

}
