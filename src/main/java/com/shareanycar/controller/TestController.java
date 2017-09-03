package com.shareanycar.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by slava on 03/09/2017.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String test(){
        return "hello world";
    }

}
