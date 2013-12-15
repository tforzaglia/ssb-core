package com.ssb.web.model;

import java.util.ArrayList;

public class Fighter {

	String name;
	int careerWins;
	int matchesPlayed;
	String isRestricted;
	int restrictedYear;
	ArrayList<String> ownersThroughTheYears;
	ArrayList<Integer> winsThroughTheYears;
	ArrayList<Float> salariesThroughTheYears;
	
	public Fighter() {
		
	}
	
	public Fighter(String name, int careerWins, int matchesPlayed, String isRestricted, int restrictedYear) {
		
		this.name = name;
		this.careerWins = careerWins;
		this.matchesPlayed = matchesPlayed;
		this.isRestricted = isRestricted;
		this.restrictedYear = restrictedYear;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCareerWins() {
		return careerWins;
	}

	public void setCareerWins(int careerWins) {
		this.careerWins = careerWins;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public String getIsRestricted() {
		return isRestricted;
	}

	public void setIsRestricted(String isRestricted) {
		this.isRestricted = isRestricted;
	}
	
	public int getRestrictedYear() {
		return restrictedYear;
	}

	public void setRestrictedYear(int restrictedYear) {
		this.restrictedYear = restrictedYear;
	}

	public ArrayList<String> getOwnersThroughTheYears() {
		return ownersThroughTheYears;
	}

	public void setOwnersThroughTheYears(ArrayList<String> ownersThroughTheYears) {
		this.ownersThroughTheYears = ownersThroughTheYears;
	}

	public ArrayList<Integer> getWinsThroughTheYears() {
		return winsThroughTheYears;
	}

	public void setWinsThroughTheYears(ArrayList<Integer> winsThroughTheYears) {
		this.winsThroughTheYears = winsThroughTheYears;
	}

	public ArrayList<Float> getSalariesThroughTheYears() {
		return salariesThroughTheYears;
	}

	public void setSalariesThroughTheYears(ArrayList<Float> salariesThroughTheYears) {
		this.salariesThroughTheYears = salariesThroughTheYears;
	}
	
	
}
