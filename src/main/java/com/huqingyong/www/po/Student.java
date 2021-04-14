package com.huqingyong.www.po;

public class Student {
    private Integer id;
    private String number;
    private String password;
    private String name;
    private String grade_academe;
    private Integer time;

    public Student() {
    }

    public Student(String number, String password, String name, String grade_academe) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.grade_academe = grade_academe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade_academe() {
        return grade_academe;
    }

    public void setGrade_academe(String grade_academe) {
        this.grade_academe = grade_academe;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", grade_academe='" + grade_academe + '\'' +
                ", time=" + time +
                '}';
    }
}
