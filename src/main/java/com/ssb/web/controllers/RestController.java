package com.ssb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssb.web.data.FighterDAO;
import com.ssb.web.model.Fighter;

@Controller
public class RestController {

	@Autowired
	FighterDAO fighterDao;
	
	// get all information for the given fighter
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public @ResponseBody Fighter getByName(@PathVariable String name) {
		
		Fighter fighter = fighterDao.findByName(name);		
		return fighter;
	}
	
	// get the number of wins for the given character and year
	@RequestMapping(value = "/getWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody int getWins(@PathVariable int year, @PathVariable String name) {
			
		int wins = fighterDao.getWinsByYear(year, name);		
		return wins;
	}
	
	// update yearly wins and career wins by 1 for the given fighter
	@RequestMapping(value = "/updateWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody int updateWins(@PathVariable int year, @PathVariable String name) {
		
		// update career wins by 1
		Fighter fighter = fighterDao.findByName(name);		
		fighter.setCareerWins(fighter.getCareerWins() + 1);
		fighterDao.updateCareerWins(fighter);
		
		// update yearly wins by 1
		int winsForYear = fighterDao.getWinsByYear(year, name);
		fighterDao.updateWinsByYear(year, winsForYear + 1, name);
		
		return winsForYear;
	}
		
}
