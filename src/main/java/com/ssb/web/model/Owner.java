package com.ssb.web.model;

import java.util.ArrayList;

public class Owner {

	private String name;
	private int careerWins;
	private ArrayList<Integer> winsThroughTheYears;
	private ArrayList<Float> salariesThroughTheYears;
	private ArrayList<Float> salaryRemainingThroughTheYears;
	private ArrayList<String> lineupsThroughTheYears;
	
	public Owner() {}
	
	public Owner(String name, int careerWins, ArrayList<Integer> winsThroughTheYears, ArrayList<Float> salariesThroughTheYears,
			ArrayList<Float> salaryRemainingThroughTheYears, ArrayList<String> lineupsThroughTheYears) {
		
		this.name = name;
		this.careerWins = careerWins;
		this.winsThroughTheYears = winsThroughTheYears;
		this.salariesThroughTheYears = salariesThroughTheYears;
		this.salaryRemainingThroughTheYears = salaryRemainingThroughTheYears;
		this.lineupsThroughTheYears = lineupsThroughTheYears;
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
	
	public ArrayList<Float> getSalaryRemainingThroughTheYears() {
		return salaryRemainingThroughTheYears;
	}
	public void setSalaryRemainingThroughTheYears(ArrayList<Float> salaryRemainingThroughTheYears) {
		this.salaryRemainingThroughTheYears = salaryRemainingThroughTheYears;
	}

	public ArrayList<String> getLineupsThroughTheYears() {
		return lineupsThroughTheYears;
	}
	public void setLineupsThroughTheYears(ArrayList<String> lineupsThroughTheYears) {
		this.lineupsThroughTheYears = lineupsThroughTheYears;
	}
}
