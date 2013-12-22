package com.ssb.web.controllers;

import java.util.ArrayList;

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
	public @ResponseBody Fighter updateWins(@PathVariable int year, @PathVariable String name) {
		
		// update career wins by 1
		Fighter fighter = fighterDao.findByName(name);		
		fighter.setCareerWins(fighter.getCareerWins() + 1);
		
		// update wins for the given year by 1
		ArrayList<Integer> yearlyWinsArray = new ArrayList<Integer>();
		yearlyWinsArray = fighter.getWinsThroughTheYears();
		int newWinsForYear = yearlyWinsArray.get(year - 1) + 1;
		yearlyWinsArray.set(year - 1, newWinsForYear);
				
		fighterDao.updateCareerWins(fighter);
		fighterDao.updateWinsByYear(fighter, year);		
		
		return fighter;
	}
	
	
		
}
