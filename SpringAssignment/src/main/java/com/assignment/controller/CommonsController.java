package com.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonsController {
	
	@RequestMapping("header")
	public String gotoHeader(){
		return "header";
	}
	
	@RequestMapping("footer")
	public String gotoFooter(){
		return "footer";
	}

}
