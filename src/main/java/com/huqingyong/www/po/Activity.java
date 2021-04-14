package com.huqingyong.www.po;

public class Activity {
    private Integer id;
    private String activityName;
    private String activityType;
    private String activitySite;
    private String activityStartTime;
    private String activityOverTime;
    private Integer activityTime;
    private Integer activityPeople;
    private String activityStatus;
    private String activityContext;
    private Integer sponsorId;
    private Integer managerId;

    public Activity() {
    }



    public Activity(String activityName, String activityType, String activitySite, String activityStartTime,
                    String activityOverTime, Integer activityTime, Integer activityPeople, String activityStatus, String activityContext) {
        this.activityName = activityName;
        this.activityType = activityType;
        this.activitySite = activitySite;
        this.activityStartTime = activityStartTime;
        this.activityOverTime = activityOverTime;
        this.activityTime = activityTime;
        this.activityPeople = activityPeople;
        this.activityStatus = activityStatus;
        this.activityContext = activityContext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityContext() {
        return activityContext;
    }

    public void setActivityContext(String activityContext) {
        this.activityContext = activityContext;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivitySite() {
        return activitySite;
    }

    public void setActivitySite(String activitySite) {
        this.activitySite = activitySite;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityOverTime() {
        return activityOverTime;
    }

    public void setActivityOverTime(String activityOverTime) {
        this.activityOverTime = activityOverTime;
    }

    public Integer getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Integer activityTime) {
        this.activityTime = activityTime;
    }

    public Integer getActivityPeople() {
        return activityPeople;
    }

    public void setActivityPeople(Integer activityPeople) {
        this.activityPeople = activityPeople;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                ", activityType='" + activityType + '\'' +
                ", activitySite='" + activitySite + '\'' +
                ", activityStartTime='" + activityStartTime + '\'' +
                ", activityOverTime='" + activityOverTime + '\'' +
                ", activityTime=" + activityTime +
                ", activityPeople=" + activityPeople +
                ", activityStatus='" + activityStatus + '\'' +
                ", activityContext='" + activityContext + '\'' +
                ", sponsorId=" + sponsorId +
                ", managerId=" + managerId +
                '}';
    }
}
