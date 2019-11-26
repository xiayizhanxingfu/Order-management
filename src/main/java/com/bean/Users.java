package com.bean;


/**
 * @author 下一张幸福
 */
public class Users {
    /**
     * 用户编号
     */
    private long usersId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 用户身份
     */
    private long userIdentity;


    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }


    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }


    public long getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(long userIdentity) {
        this.userIdentity = userIdentity;
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userIdentity=" + userIdentity +
                '}';
    }
}
