package io.spring.demo.decorator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author raphael.rodrigues
 */
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

    @RequestMapping(value="/content")
    public String content() {
        return "Content1";
    }
}
