package com.huqingyong.www.po;

public class Announcement {
    private Integer announcementId;
    private String context;

    public Announcement() {
    }

    public Announcement(Integer announcementId, String context) {
        this.announcementId = announcementId;
        this.context = context;
    }

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", context='" + context + '\'' +
                '}';
    }
}
