package com.ssb.web.controllers;

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
}
