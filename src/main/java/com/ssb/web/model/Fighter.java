package com.ssb.web.model;

public class Fighter {

	String name;
	int careerWins;
	int matchesPlayed;
	char isRestricted;
	int restrictedYear;
	
	public Fighter() {
		
	}
	
	public Fighter(String name, int careerWins, int matchesPlayed, char isRestricted, int restrictedYear) {
		
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

	public char isRestricted() {
		return isRestricted;
	}

	public void setRestricted(char isRestricted) {
		this.isRestricted = isRestricted;
	}

	public int getRestrictedYear() {
		return restrictedYear;
	}

	public void setRestrictedYear(int restrictedYear) {
		this.restrictedYear = restrictedYear;
	}
}
