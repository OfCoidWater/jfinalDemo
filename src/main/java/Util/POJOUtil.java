package Util;

import bean.User;
import com.jfinal.plugin.activerecord.Model;

import java.lang.reflect.Field;

public class POJOUtil {
    @SuppressWarnings("rawtypes")
    public static <T> T modelToBean(Model<?> model, Class<T> bean) {
        T target = null;
        try {
            if (null != model) {
                Class _target = bean;
                //反射获取声明的字段
                Field[] declaredFields = bean.getDeclaredFields();
                do {
                    for (Field field : declaredFields) {
                        field.setAccessible(true);
                        // 将model中的属相值set到javaBean中
                        setBeanValue(model, field, target);
                    }
                    _target = _target.getSuperclass();
                } while (!_target.getName().equals(Object.class.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    private static <T> void setBeanValue(Model<?> model, Field field, T target) {

    }

}
