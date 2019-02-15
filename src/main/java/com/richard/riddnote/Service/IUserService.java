package com.richard.riddnote.Service;

import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Model.Vo.UserVo;

import java.util.Map;


public interface IUserService {

    UserBo login(UserVo userVo);

    Map GetUserInfo(String uid);

    boolean CheckUserLoginStatus(String uid);
}

