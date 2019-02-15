package com.richard.riddnote.Model.Bo;

import com.richard.riddnote.Model.Vo.UserVo;

public class UserBo {

    private String uid;

    private String username;

    private String password;

    private boolean valid;


    static public UserBo CreateBoCreteria(UserVo userVo)
    {
        UserBo userBo= new UserBo();

        userBo.setUsername(userVo.getUsername());
        userBo.setPassword(userVo.getPassword());

        return userBo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
