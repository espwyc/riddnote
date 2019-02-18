package com.richard.riddnote.Controller;


import com.richard.riddnote.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {

    private final IUserService userService;

    @Autowired
    public IndexController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"","/","/index","/home"})
    public String Home(ModelMap modelMap, HttpServletRequest request)
    {
        HttpSession session= request.getSession();
        //
        // 验证session?
        //
        Map<String,String> map= userService.GetUserInfo((String)session.getAttribute("uid"));

        modelMap.addAttribute("userinfo",map);

        return "home/home";
    }

}
