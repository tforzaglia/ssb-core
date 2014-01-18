package com.ssb.web.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssb.web.data.OwnerDAO;
import com.ssb.web.model.Owner;

@Controller
@RequestMapping(value = "/owner", method = RequestMethod.GET)
public class OwnerController {

	@Autowired
	OwnerDAO ownerDao;
	
	// get all information for the given owner
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
	public @ResponseBody Owner getByName(@PathVariable String name) {
		
		Owner owner = ownerDao.findByName(name);		
		return owner;
	}
	
	// get the number of career wins for the given owner
	@RequestMapping(value = "/getCareerWins/{name}", method = RequestMethod.GET)
	public @ResponseBody int getCareerWins(@PathVariable String name) {
					
		Owner owner = ownerDao.findByName(name);
		int careerWins = owner.getCareerWins();
			
		return careerWins;
	}
	
	// get the number of wins for the given owner and year
	@RequestMapping(value = "/getWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody int getWinsForYear(@PathVariable int year, @PathVariable String name) {
				
		Owner owner = ownerDao.findByName(name);
		ArrayList<Integer> yearlyWinsArray = new ArrayList<Integer>();
		yearlyWinsArray = owner.getWinsThroughTheYears();
		int winsForYear = yearlyWinsArray.get(year - 1);	
			
		return winsForYear;
	}
	
	// update yearly wins and career wins by 1 for the given owner and year
	@RequestMapping(value = "/updateWins/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody Owner updateWins(@PathVariable int year, @PathVariable String name) {
			
		// update career wins by 1
		Owner owner = ownerDao.findByName(name);		
		owner.setCareerWins(owner.getCareerWins() + 1);
			
		// update wins for the given year by 1
		ArrayList<Integer> yearlyWinsArray = new ArrayList<Integer>();
		yearlyWinsArray = owner.getWinsThroughTheYears();
		int newWinsForYear = yearlyWinsArray.get(year - 1) + 1;
		yearlyWinsArray.set(year - 1, newWinsForYear);
					
		ownerDao.updateCareerWins(owner);
		ownerDao.updateWinsByYear(owner, year);		
			
		return owner;
	}
	
	// get the total salary for the given owner and year
	@RequestMapping(value = "/getTotalSalary/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody float getSalaryForYear(@PathVariable int year, @PathVariable String name) {
						
		Owner owner = ownerDao.findByName(name);
		ArrayList<Float> yearlySalariesArray = new ArrayList<Float>();
		yearlySalariesArray = owner.getSalariesThroughTheYears();
		float salaryForYear = yearlySalariesArray.get(year - 1);		
			
		return salaryForYear;
	}
	
	// update yearly total salary for the given owner and year
	// NOTE: need to have a trailing / when hitting the endpoint in order for the decimal point to be updated properly
	@RequestMapping(value = "/updateTotalSalary/{year}/{name}/{salary}", method = RequestMethod.GET)
	public @ResponseBody Owner updateTotalSalary(@PathVariable int year, @PathVariable String name, @PathVariable float salary) {
					
		Owner owner = ownerDao.findByName(name);					
		ArrayList<Float> yearlySalariesArray = new ArrayList<Float>();
		yearlySalariesArray = owner.getSalariesThroughTheYears();
				
		yearlySalariesArray.set(year - 1, salary);
		ownerDao.updateTotalSalaryByYear(owner, year);
									
		return owner;
	}
	
	// get the salary remaining for the given owner and year
	@RequestMapping(value = "/getSalaryRemaining/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody float getSalaryRemainingForYear(@PathVariable int year, @PathVariable String name) {
							
		Owner owner = ownerDao.findByName(name);
		ArrayList<Float> yearlySalariesArray = new ArrayList<Float>();
		yearlySalariesArray = owner.getSalaryRemainingThroughTheYears();
		float salaryRemainingForYear = yearlySalariesArray.get(year - 1);		
				
		return salaryRemainingForYear;
	}
	
	// update yearly salary remaining for the given owner and year
	// NOTE: need to have a trailing / when hitting the endpoint in order for the decimal point to be updated properly
	@RequestMapping(value = "/updateSalaryRemaining/{year}/{name}/{salary}", method = RequestMethod.GET)
	public @ResponseBody Owner updateSalaryRemaining(@PathVariable int year, @PathVariable String name, @PathVariable float salary) {
						
		Owner owner = ownerDao.findByName(name);					
		ArrayList<Float> yearlySalariesArray = new ArrayList<Float>();
		yearlySalariesArray = owner.getSalaryRemainingThroughTheYears();
					
		yearlySalariesArray.set(year - 1, salary);
		ownerDao.updateSalaryRemainingByYear(owner, year);
										
		return owner;
	}
	
	// get the lineup for the given owner and year
	@RequestMapping(value = "/getLineup/{year}/{name}", method = RequestMethod.GET)
	public @ResponseBody String getLineupForYear(@PathVariable int year, @PathVariable String name) {
								
		Owner owner = ownerDao.findByName(name);
		ArrayList<String> lineupsArray = new ArrayList<String>();
		lineupsArray = owner.getLineupsThroughTheYears();
		String lineupForYear = lineupsArray.get(year - 1);		
					
		return lineupForYear;
	}
	
	// update the lineup for the given owner and year 
	@RequestMapping(value = "/updateLineup/{year}/{name}/{lineup}", method = RequestMethod.GET)
	public @ResponseBody Owner updateLineup(@PathVariable int year, @PathVariable String name, @PathVariable String lineup) {
						
		Owner owner = ownerDao.findByName(name);					
		ArrayList<String> lineupsArray = new ArrayList<String>();
		lineupsArray = owner.getLineupsThroughTheYears();
					
		lineupsArray.set(year - 1, lineup);
		ownerDao.updateLineupByYear(owner, year);
										
		return owner;
	}
}
