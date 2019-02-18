package com.richard.riddnote.Controller;


import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Service.IMarkdownsService;
import com.richard.riddnote.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EditorController {

    private final IMarkdownsService markdownsService;
    private final IUserService userService;

    @Autowired
    public EditorController(IMarkdownsService markdownsService, IUserService userService) {
        this.markdownsService = markdownsService;
        this.userService = userService;
    }

    @RequestMapping("/edit")
    public String Test(@RequestParam String uid, ModelMap modelMap, HttpServletRequest request)
    {
        MarkdownBo markdownBo= markdownsService.GetMarkdown(uid);

        Map<String,Object> map= new HashMap<>();
        map.put("title",markdownBo.getTitle());
        map.put("nickname",markdownBo.getUsernickname());
        map.put("content",markdownBo.getContent());
        map.put("uid",markdownBo.getUid());

        modelMap.addAttribute("Mdc",map);

        HttpSession session= request.getSession();
        //
        // 验证session?
        //
        Map<String,String> map1= userService.GetUserInfo((String)session.getAttribute("uid"));

        modelMap.addAttribute("userinfo",map1);

        return "editor/fullpage";
    }


    @RequestMapping("fullpage")
    public String full()
    {
        return "editor/fullpage";
    }
}
