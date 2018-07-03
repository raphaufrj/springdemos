package com.demo.raphaufrj.demoweblogic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
	
	@RequestMapping(method = RequestMethod.GET)
	String readResource() {
		return "hello!";
	}
}
