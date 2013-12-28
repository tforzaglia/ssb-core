package com.ssb.web.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.ssb.web.model.Fighter;
 
@SuppressWarnings("rawtypes")
public class FighterRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Fighter fighter = new Fighter();
		ArrayList<String> owners = new ArrayList<String>();
		ArrayList<Integer> wins = new ArrayList<Integer>();
		ArrayList<Float> salaries = new ArrayList<Float>();
		
		fighter.setName(rs.getString("name"));
		fighter.setCareerWins(rs.getInt("career_wins"));
		fighter.setMatchesPlayed(rs.getInt("matches_played"));
		fighter.setIsRestricted(rs.getString("is_restricted"));
		fighter.setRestrictedYear(rs.getInt("restricted_year"));
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();

		// loop through all the columns in the table 
		for (int i = 1; i < numberOfColumns + 1; i++) {
		    String columnName = rsMetaData.getColumnName(i);
		    // check if the column name is one of the year*_ columns
		    if (columnName.contains("_owner")) {
		        owners.add(rs.getString(columnName));
		    }
		    else if (columnName.contains("_wins") && !columnName.contains("career")) {
		        wins.add(rs.getInt(columnName));
		    }
		    else if (columnName.contains("_salary")) {
		        salaries.add(rs.getFloat(columnName));
		    }
		}
		
		fighter.setOwnersThroughTheYears(owners);
		fighter.setWinsThroughTheYears(wins);
		fighter.setSalariesThroughTheYears(salaries);
		
		return fighter;
	}
}