package com.hcl.taco.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class RequestHcl {

    @GetMapping("/1")
    @ResponseBody
    public String  test(){
        return "test";
    }

    @GetMapping("2")
    public String test2(){
        return "1";
    }
}
