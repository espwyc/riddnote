package com.richard.riddnote.Controller;

import com.richard.riddnote.Exception.AuthException;
import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Model.Vo.UserRegisterVo;
import com.richard.riddnote.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    private final IUserService userService;

    @Autowired
    public RegisterController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String GetRegister()
    {
        return "register/index";
    }

    @PostMapping("/register")
    @ResponseBody
    public Object DoRegist(UserRegisterVo userRegisterVo)
    {
        Map<String,String> map = new HashMap<>();
        if(!userRegisterVo.getInvicode().equals("uestc2020"))
        {
            map.put("res","false");
            return map;
        }

        if(!userRegisterVo.getPassword().equals(userRegisterVo.getCfpwd()))
        {
            map.put("res","false");
            return map;
        }

        UserBo userBo = UserBo.CreateBoCreteria(userRegisterVo);

        try {
            userService.CreateNewUser(userBo);
        }
        catch (Exception e)
        {
            map.put("res","false");
            if(e instanceof AuthException)
            {
                map.put("msg",e.getMessage());
            }
            else
            {
                map.put("msg","其他原因");
            }
        }

        map.put("res","ok");
        return map;
    }
}
