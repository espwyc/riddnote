package com.richard.riddnote.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditorController {

    @GetMapping("/md")
    public String Test(@RequestParam String uid)
    {
        System.out.println(uid);

        return "editor/fullpage";
    }
}
