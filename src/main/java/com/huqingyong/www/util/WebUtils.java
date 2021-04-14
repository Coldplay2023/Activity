package com.huqingyong.www.util;

import com.huqingyong.www.po.Activity;
import com.huqingyong.www.po.Sponsor;
import com.huqingyong.www.po.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        try{
            if(string!=null){
                return Integer.parseInt(string);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static List<Activity> activityList(ResultSet rs) throws SQLException {
        List<Activity> activities=new ArrayList<>();
        while(rs.next()){
            Activity activity=new Activity();
            activity.setActivityName(rs.getString("activityName"));
            activity.setActivityType(rs.getString("activityType"));
            activity.setActivitySite(rs.getString("activitySite"));
            activity.setActivityStartTime(rs.getString("activityStartTime"));
            activity.setActivityOverTime(rs.getString("activityOverTime"));
            activity.setActivityTime(rs.getInt("activityTime"));
            activity.setActivityPeople(rs.getInt("activityPeople"));
            activity.setActivityContext(rs.getString("activityContext"));
            activity.setId(rs.getInt("id"));
            activity.setSponsorId((rs.getInt("sponsorId")));
            activity.setManagerId(rs.getInt("managerId"));
            activities.add(activity);
        }
        return activities;
    }


    public static List<Sponsor> sponsorList (ResultSet rs) throws SQLException {
        List<Sponsor> sponsors=new ArrayList<>();
        while(rs.next()){
            Sponsor sponsor=new Sponsor();
            sponsor.setId(rs.getInt("id"));
            sponsor.setAccount(rs.getString("account"));
            sponsor.setClubName(rs.getString("clubName"));
            sponsor.setClubIntroduction(rs.getString("clubIntroduction"));
            sponsor.setPrincipalName(rs.getString("principalName"));
            sponsor.setPrincipalContact(rs.getString("principalContact"));
            sponsors.add(sponsor);
        }
        return sponsors;
    }
    public static List<Student> studentList (ResultSet rs) throws SQLException {
        List<Student> students=new ArrayList<>();
        while(rs.next()){
            Student student=new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setNumber(rs.getString("number"));
            student.setGrade_academe(rs.getString("grade_academe"));
            students.add(student);
        }
        return students;
    }


}
