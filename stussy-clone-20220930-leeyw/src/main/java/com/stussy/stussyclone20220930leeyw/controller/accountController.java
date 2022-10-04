package com.stussy.stussyclone20220930leeyw.controller;

import com.stussy.stussyclone20220930leeyw.dto.RegisterReqDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class accountController {

    @GetMapping("/account/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/account/register")
    public String register(RegisterReqDto registerReqDto) {
        return "account/register";
    }
}
