package com.huqingyong.www.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//第四层：将获取参数代码封装成工具类，工具类如果有对象，都要写成object对象
public class WebUtils {
    public static  <T> T  copyParamTOBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String string,int defaultValue) {
        //没有参数居然进去了？
        try{
            if(string!=null){
                return Integer.parseInt(string);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;


    }
}
