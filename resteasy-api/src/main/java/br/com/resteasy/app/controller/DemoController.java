package br.com.resteasy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {


    @RequestMapping(value="/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="/about")
    public String about() {
        return "about";
    }

}