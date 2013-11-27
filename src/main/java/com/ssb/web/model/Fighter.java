package com.ssb.web.model;

public class Fighter {

	String name;
	int wins;
	int matchesPlayed;
	
	public Fighter() {
		
	}
	
	public Fighter(String name, int wins, int matchesPlayed) {
		
		this.name = name;
		this.wins = wins;
		this.matchesPlayed = matchesPlayed;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
}
