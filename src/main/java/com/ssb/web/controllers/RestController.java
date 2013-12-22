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
	
	// get the number of career wins for the given character
	@RequestMapping(value = "/getCareerWins/{name}", method = RequestMethod.GET)
	public @ResponseBody int getCareerWins(@PathVariable String name) {
				
		Fighter fighter = fighterDao.findByName(name);
		int careerWins = fighter.getCareerWins();
		return careerWins;
	}
	
	// get the number of wins for the given character and year
	@RequestMapping(value = "/getWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody int getWinsForYear(@PathVariable int year, @PathVariable String name) {
			
		Fighter fighter = fighterDao.findByName(name);
		ArrayList<Integer> yearlyWinsArray = new ArrayList<Integer>();
		yearlyWinsArray = fighter.getWinsThroughTheYears();
		int winsForYear = yearlyWinsArray.get(year - 1);		
		return winsForYear;
	}
	
	// update yearly wins and career wins by 1 for the given fighter and year
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
	
	// get the restricted status for the given character
	@RequestMapping(value = "/getRestrictedStatus/{name}", method = RequestMethod.GET)
	public @ResponseBody String getRestrictedStatus(@PathVariable String name) {
					
		Fighter fighter = fighterDao.findByName(name);
		String isRestricted = fighter.getIsRestricted();
		return isRestricted;
	}
	
	// set the given restricted status for the given character
	@RequestMapping(value = "/setRestrictedStatus/{name}/{restrictedStatus}", method = RequestMethod.GET)
	public @ResponseBody Fighter setRestrictedStatus(@PathVariable String name, @PathVariable String restrictedStatus) {
						
		Fighter fighter = fighterDao.findByName(name);
		if(restrictedStatus.equals("N") || restrictedStatus.equals("Y")) {
			fighter.setIsRestricted(restrictedStatus);
			fighterDao.updateRestrictedStatus(fighter);
		}

		return fighter;
	}
	
	// get the restricted year for the given character
	@RequestMapping(value = "/getRestrictedYear/{name}", method = RequestMethod.GET)
	public @ResponseBody int getRestrictedYear(@PathVariable String name) {
						
		Fighter fighter = fighterDao.findByName(name);
		int restrictedYear = fighter.getRestrictedYear();
		return restrictedYear;
	}
	
	// set the restricted year for the given character 
	@RequestMapping(value = "/setRestrictedYear/{name}/{restrictedYear}", method = RequestMethod.GET)
	public @ResponseBody Fighter setRestrictedYear(@PathVariable String name, @PathVariable int restrictedYear) {
		
		Fighter fighter = fighterDao.findByName(name);
		fighter.setRestrictedYear(restrictedYear);
		fighterDao.updateRestrictedYear(fighter);
		return fighter;
	}
}
