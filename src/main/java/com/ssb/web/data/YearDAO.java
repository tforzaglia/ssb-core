package com.ssb.web.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Year;

public class YearDAO {

	@Autowired
	private DataSource dataSource;	
	
	// retrieve all data related to the specified year from the database
	@SuppressWarnings({ "rawtypes" })
	public Year findByYear(int year){

		String yearColumn = "YEAR" + year;
		String sql = "SELECT * FROM " + yearColumn;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		Year yearObj = new Year();
		ArrayList<Integer> matches = new ArrayList<Integer>();
		ArrayList<String> fighterWinners = new ArrayList<String>();
		ArrayList<String> ownerWinners = new ArrayList<String>();
		
		for (Map row : rows) {
			matches.add(Integer.parseInt(String.valueOf(row.get("match"))));
			fighterWinners.add(String.valueOf(row.get("character_winner")));
			ownerWinners.add(String.valueOf(row.get("owner_winner")));
		}

		yearObj.setMatches(matches);
		yearObj.setFighterWinners(fighterWinners);
		yearObj.setOwnerWinners(ownerWinners);
		
		return yearObj;
	}
}
