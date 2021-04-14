package com.huqingyong.www.po;

public class Sponsor {
    private Integer id;
    private String account;
    private String password;
    private String clubName;
    private String principalName;
    private String principalContact;
    private String clubIntroduction;
    private Integer managerId;

    public Sponsor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sponsor(String account, String password, String clubName, String principalName, String principalContact, String clubIntroduction) {
        this.account = account;
        this.password = password;
        this.clubName = clubName;
        this.principalName = principalName;
        this.principalContact = principalContact;
        this.clubIntroduction = clubIntroduction;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getPrincipalContact() {
        return principalContact;
    }

    public void setPrincipalContact(String principalContact) {
        this.principalContact = principalContact;
    }


    public String getClubIntroduction() {
        return clubIntroduction;
    }

    public void setClubIntroduction(String clubIntroduction) {
        this.clubIntroduction = clubIntroduction;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }


    @Override
    public String toString() {
        return "Sponsor{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", clubName='" + clubName + '\'' +
                ", principalName='" + principalName + '\'' +
                ", principalContact='" + principalContact + '\'' +
                ", clubIntroduction='" + clubIntroduction + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
