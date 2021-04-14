package com.huqingyong.www.po;

public class Manager {
    private Integer id;
    private String managerAccount;
    private String managerPassword;

    public Manager() {
    }

    public Manager(Integer id, String managerAccount, String managerPassword) {
        this.id = id;
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Override
    public String toString() {
        return "manager{" +
                "id=" + id +
                ", managerAccount='" + managerAccount + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                '}';
    }
}
