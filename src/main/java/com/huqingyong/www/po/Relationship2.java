package com.huqingyong.www.po;

public class Relationship2 {
    private Integer id;
    private Integer studentId;
    private Integer sponsorId;
    private Integer activityId;

    public Relationship2() {
    }

    public Relationship2(Integer id, Integer studentId, Integer sponsorId, Integer activityId) {
        this.id = id;
        this.studentId = studentId;
        this.sponsorId = sponsorId;
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

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "Relationship2{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", sponsorId=" + sponsorId +
                ", activityId=" + activityId +
                '}';
    }
}
