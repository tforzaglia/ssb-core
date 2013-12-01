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
	
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public @ResponseBody Fighter getByName(@PathVariable String name) {
		
		Fighter fighter = fighterDao.findByName(name);		
		return fighter;
	}
	
	@RequestMapping(value = "/updateWins/{name}", method = RequestMethod.GET)
	public @ResponseBody int updateWins(@PathVariable String name) {
		
		Fighter fighter = fighterDao.findByName(name);		
		fighter.setWins(fighter.getWins() + 1);
		fighterDao.updateWins(fighter);
		
		return fighter.getWins();
	}
	
	/*@RequestMapping(value = "/post.json", method = RequestMethod.POST)
	public @ResponseBody void insertTest(@RequestBody final  Fighter fighter) {
		
		fighterDao.insert(fighter);
	}	*/
}
