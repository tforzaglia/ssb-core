package com.ssb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssb.web.data.FighterDAO;
import com.ssb.web.model.Fighter;

@Controller
public class TestController {

	@Autowired
	FighterDAO fighterDao;
	
	// get all information for the given fighter
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public @ResponseBody Fighter getByName(@PathVariable String name) {
		
		Fighter fighter = fighterDao.findByName(name);		
		return fighter;
	}
	
	// updates the 
	@RequestMapping(value = "/updateWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody int updateWins(@PathVariable String year, @PathVariable String name) {
		
		Fighter fighter = fighterDao.findByName(name);		
		fighter.setCareerWins(fighter.getCareerWins() + 1);
		fighterDao.updateWins(fighter);
		
		return fighter.getCareerWins();
	}
	
}
