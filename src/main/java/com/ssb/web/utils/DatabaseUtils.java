package com.ssb.web.utils;

public class DatabaseUtils {
	
	public static String getYearColumn(int year) {
		
		String yearString = "";		
		switch(year) {
			case 1: yearString = "YEAR1_WINS";
					break;
			case 2: yearString = "YEAR2_WINS";
					break;
			case 3: yearString = "YEAR3_WINS";
					break;
			case 4: yearString = "YEAR4_WINS";
					break;
			case 5: yearString = "YEAR5_WINS";
					break;
			case 6: yearString = "YEAR6_WINS";
					break;
		}		
		return yearString;
	}

}
