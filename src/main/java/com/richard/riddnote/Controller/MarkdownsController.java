package com.richard.riddnote.Controller;

import com.richard.riddnote.Exception.AuthException;
import com.richard.riddnote.Exception.DataBaseException;
import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Model.Bo.UserBo;
import com.richard.riddnote.Model.Dto.MdinfoDto;
import com.richard.riddnote.Model.Vo.MarkdownVo;
import com.richard.riddnote.Service.IMarkdownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class MarkdownsController {

    private final IMarkdownsService markdownsService;

    @Autowired
    public MarkdownsController(IMarkdownsService markdownsService) {
        this.markdownsService = markdownsService;
    }

    @PostMapping("/newmd")
    @ResponseBody
    public Object CreateNewMarkdown(MarkdownVo newmdVo, HttpServletRequest request)
    {
        Map<String,String> map = new HashMap<>();

        MarkdownBo markdownBo = MarkdownBo.CreatrBoCreteria(newmdVo);

        HttpSession session = request.getSession();

        UserBo userBo = new UserBo();
        userBo.setUid((String) session.getAttribute("uid"));

        try
        {
            markdownsService.CreateNewMarkdown(markdownBo,userBo);
        }
        catch (Exception e)
        {
            map.put("res","false");
            if(e instanceof AuthException)
            {
                map.put("msg","用户信息无效");
            }
            if(e instanceof DataBaseException)
            {
                map.put("msg","无该用户");
            }
            return map;
        }
        map.put("res","ok");

        return map;
    }

    @GetMapping("/list")
    @ResponseBody
    public Object GetMdList(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);

        UserBo userBo= new UserBo();
        userBo.setUid((String) session.getAttribute("uid"));

        Set<MarkdownBo> markdownBos = markdownsService.GetMdList(userBo);

        Set<MdinfoDto> mdinfoDtos= new HashSet<>();

        for(MarkdownBo mdb: markdownBos)
        {
            mdinfoDtos.add(MdinfoDto.CreateDtoCreteria(mdb));
        }

        return mdinfoDtos;
    }
}
