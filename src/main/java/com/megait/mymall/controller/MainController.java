package com.megait.mymall.controller;

import com.megait.mymall.user.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "My Store");
        return "/view/index";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute(new SignUpForm()); // 빈 DTO 그릇을 View 에게 전달
        return "/view/signup";
    }

}
