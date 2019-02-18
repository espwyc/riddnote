package com.richard.riddnote.Controller;


import com.richard.riddnote.Model.Bo.MarkdownBo;
import com.richard.riddnote.Service.IMarkdownsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EditorController {

    private final IMarkdownsService markdownsService;

    @Autowired
    public EditorController(IMarkdownsService markdownsService) {
        this.markdownsService = markdownsService;
    }

    @RequestMapping("/edit")
    public String Test(@RequestParam String uid, ModelMap modelMap)
    {
        MarkdownBo markdownBo= markdownsService.GetMarkdown(uid);

        Map<String,Object> map= new HashMap<>();
        map.put("title",markdownBo.getTitle());
        map.put("nickname",markdownBo.getUsernickname());
        map.put("content",markdownBo.getContent());

        modelMap.addAttribute("Mdc",map);

        return "editor/fullpage";
    }


    @RequestMapping("fullpage")
    public String full()
    {
        return "editor/fullpage";
    }
}
