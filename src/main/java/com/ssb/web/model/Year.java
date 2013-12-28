package com.ssb.web.model;

import java.util.ArrayList;

public class Year {

	private ArrayList<Integer> matches;
	private ArrayList<String> fighterWinners;
	private ArrayList<String> ownerWinners;
	
	public Year() {}
	
	public Year(ArrayList<Integer> matches, ArrayList<String> fighterWinners, ArrayList<String> ownerWinners) {
		
		this.matches = matches;
		this.fighterWinners = fighterWinners;
		this.ownerWinners = ownerWinners;
	}

	public ArrayList<Integer> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<Integer> matches) {
		this.matches = matches;
	}

	public ArrayList<String> getFighterWinners() {
		return fighterWinners;
	}

	public void setFighterWinners(ArrayList<String> fighterWinners) {
		this.fighterWinners = fighterWinners;
	}

	public ArrayList<String> getOwnerWinners() {
		return ownerWinners;
	}

	public void setOwnerWinners(ArrayList<String> ownerWinners) {
		this.ownerWinners = ownerWinners;
	}
	
	
	
}
