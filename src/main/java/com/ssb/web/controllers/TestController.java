package com.ssb.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class TestController {

	@RequestMapping(value = "/index.html")
	public String hellowWorldHtml(HttpServletRequest request, Model model) {
		return "hello";
	}
}
