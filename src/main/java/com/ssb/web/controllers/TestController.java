package com.ssb.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssb.web.data.FighterDAO;
import com.ssb.web.model.Fighter;
import com.ssb.web.model.Foo;

@Controller
public class TestController {

	@Autowired
	FighterDAO fighterDao;
	
	@RequestMapping(value = {"/index.json","/index.xml"})
	public @ResponseBody Fighter hellowWorld(HttpServletRequest request) {
		Foo myFoo = new Foo("spring", "rocks");
		
		Fighter fighter = fighterDao.findByName("Fox");
		
		return fighter;
	}
	
	@RequestMapping(value = "/index.html")
	public String hellowWorldHtml(HttpServletRequest request, Model model) {
		Foo myFoo = new Foo("spring", "rocks");
		model.addAttribute("foo", myFoo);
		return "foo";
	}
}
