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
		
	// get all information for the given fighter
	@RequestMapping(value = "/get/{year}", method = RequestMethod.GET)
	public @ResponseBody Year getByYear(@PathVariable int year) {
		
		Year yearObj = yearDao.findByYear(year);		
		return yearObj;
	}
	
	// update the winners for the given match of the given year
	@RequestMapping(value = "/updateWinners/{year}/{matchNumber}/{fighter}/{owner}", method = RequestMethod.GET)
	public @ResponseBody void updateMatchResult(@PathVariable int year, @PathVariable int matchNumber, @PathVariable String fighter, @PathVariable String owner) {
		
		yearDao.updateWinnersForMatch(year, fighter, owner, matchNumber);
	}
}
