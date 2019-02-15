package com.richard.riddnote.Service.Impl;

import com.richard.riddnote.Dao.UserRepository;
import com.richard.riddnote.Domain.User;
import com.richard.riddnote.Exception.AuthException;
import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Model.Vo.UserVo;
import com.richard.riddnote.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserBo login(UserVo userVo) {
        if(userVo==null)
        {
            throw new AuthException("空视图对象");

        }
        if(userVo.getUsername()==null)
        {
            throw new AuthException("密码为空");
        }
        if(userVo.getPassword()==null)
        {
            throw new AuthException("用户名为空");
        }
        User user= userRepository.findByUname(userVo.getUsername());
        if(user==null)
        {
            throw new AuthException("用户名/密码不匹配");
        }
        if(!user.getUname().equals(userVo.getUsername())||!user.getPwd().equals(userVo.getPassword()))
        {
            throw new AuthException("用户名/密码不匹配");
        }

        UserBo userBo = new UserBo();
        userBo.setUid(user.getUid());
        userBo.setValid(user.isValid());
        return userBo;
    }

    @Override
    public Map GetUserInfo(String uid) {
        User user= userRepository.findByUid(uid);
        if(user==null)
        {
            throw new AuthException("没有该用户");
        }
        Map<String,String> map = new HashMap<>();
        map.put("nickname",user.getNickname());
        map.put("intro",user.getIntro());
        return map;
    }

    @Override
    public boolean CheckUserLoginStatus(String uid) {
        User user = userRepository.findByUid(uid);
        if(user==null)
        {
            return false;
        }
        /*
        @author richard
        @date 2/13/2019
        这里应该判断数据库里登陆记录是否匹配，防止伪造sessionid？？
        */
        return true;
    }
}
