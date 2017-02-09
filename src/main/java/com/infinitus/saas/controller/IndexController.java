package com.infinitus.saas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by administrator on 17/2/7.
 */
@Controller
public class IndexController {
    @RequestMapping({"/"})
    @ResponseBody
    public String home()
    {
        System.out.println("index page.");
        return "welcome,helloword,项目已正常启动，运行正常!";
    }
}
