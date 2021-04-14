package com.huqingyong.www.po;

public class Relationship1 {
    private Integer id;
    private Integer studentId;
    private Integer activityId;

    public Relationship1() {
    }

    public Relationship1(Integer id, Integer studentId, Integer activityId) {
        this.id = id;
        this.studentId = studentId;
        this.activityId = activityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "relationship1{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", activityId=" + activityId +
                '}';
    }
}
