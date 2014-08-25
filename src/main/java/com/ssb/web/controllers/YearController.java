package com.ssb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssb.web.data.YearDAO;
import com.ssb.web.model.Year;

@Controller
@RequestMapping(value = "/year", method = RequestMethod.GET)
public class YearController {

	@Autowired
	YearDAO yearDao;
		
	// get all information for the given year
	@RequestMapping(value = "/get/{year}", method = RequestMethod.GET)
	public @ResponseBody Year getByYear(@PathVariable int year) {		
		Year yearObj = yearDao.findByYear(year);		
		return yearObj;
	}
	
	// update the winning fighter for the given match of the given year
	@RequestMapping(value = "/updateWinningFighter/{year}/{matchNumber}/{fighter}", method = RequestMethod.GET)
	public @ResponseBody void updateWinningFighterMatchResult(@PathVariable int year, @PathVariable int matchNumber, @PathVariable String fighter) {		
		yearDao.updateWinningFighterForMatch(year, fighter, matchNumber);
	}
	
	// update the winning owner for the given match of the given year
	@RequestMapping(value = "/updateWinningOwner/{year}/{matchNumber}/{owner}", method = RequestMethod.GET)
	public @ResponseBody void updateWinningOwnerMatchResult(@PathVariable int year, @PathVariable int matchNumber, @PathVariable String owner) {		
		yearDao.updateWinningOwnerForMatch(year, owner, matchNumber);
	}
}
