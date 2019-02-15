package com.richard.riddnote.Controller;

import com.richard.riddnote.Exception.AuthException;
import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Model.Vo.UserVo;
import com.richard.riddnote.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
public class AuthController {


    private final IUserService userService;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Login(ModelMap map)
    {
        Map<String,Integer> varmap= new HashMap<>();
        varmap.put("rdm",new Random().nextInt(4));
        map.addAllAttributes(varmap);
        return "login/index";
    }

    @PostMapping("/login")
    @ResponseBody
    //public Object DoLogin(@RequestParam String username,@RequestParam String password,HttpServletRequest request)
    public Object DoLogin(UserVo userVo, HttpServletRequest request)
    {
        System.out.println(userVo.getUsername());
        System.out.println(userVo.getPassword());
        Map<String,String> map = new HashMap<>();
        //
        // 登陆验证
        //
        try {
            UserBo userBo= userService.login(userVo);

            HttpSession session = request.getSession();
            session.setAttribute("uid",userBo.getUid());

            map.put("res","ok");
            map.put("url","/home");

            return map;
        }
        catch (Exception e)
        {
            map.put("res","false");
            if(e instanceof AuthException)
            {
                map.put("msg",e.getMessage());
                return map;
            }
            return map;
        }
    }

    @RequestMapping("/logout")
    public void DoLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session= request.getSession(false);
        if(session==null)
        {
            /*
            @author richard
            @date 2/13/2019
            没有登陆session
            */
            response.sendRedirect("login");
            return;
        }
        if(userService.CheckUserLoginStatus((String) session.getAttribute("uid")))
        {
            /*
            @author richard
            @date 2/13/2019
            判断为有效登陆，销毁session
            */
            session.removeAttribute("uid");
            session.invalidate();
            response.sendRedirect("login");
            return;
        }
        else
        {
            /*
            @author richard
            @date 2/13/2019
            创建了session却没有查找到用户
            */
            session.removeAttribute("uid");
            session.invalidate();
            response.sendRedirect("login");
            return;
        }
    }
}
