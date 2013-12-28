package com.ssb.web.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.ssb.web.model.Owner;

@SuppressWarnings("rawtypes")
public class OwnerRowMapper implements RowMapper {
	
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Owner owner = new Owner();
		ArrayList<Integer> wins = new ArrayList<Integer>();
		ArrayList<Float> salaries = new ArrayList<Float>();
		ArrayList<Float> salariesRemaining = new ArrayList<Float>();
		
		owner.setName(rs.getString("name"));
		owner.setCareerWins(rs.getInt("career_wins"));
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();

		// loop through all the columns in the table 
		for (int i = 1; i < numberOfColumns + 1; i++) {
		    String columnName = rsMetaData.getColumnName(i);
		    // check if the column name is one of the year*_ columns
		    if (columnName.contains("_wins") && !columnName.contains("career")) {
		        wins.add(rs.getInt(columnName));
		    }
		    else if (columnName.contains("_total_salary")) {
		    	salaries.add(rs.getFloat(columnName));
		    }
		    else if (columnName.contains("_salary_remaining")) {
		    	salariesRemaining.add(rs.getFloat(columnName));
		    }
		}
		
		owner.setWinsThroughTheYears(wins);
		owner.setSalariesThroughTheYears(salaries);
		owner.setSalaryRemainingThroughTheYears(salariesRemaining);
		
		return owner;
	}
}
