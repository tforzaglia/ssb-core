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
	public Year findByYear(int year) {
		String yearTable = "YEAR" + year;
		String sql = "SELECT * FROM " + yearTable;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		
		Year yearObj = new Year();
		ArrayList<Integer> matches = new ArrayList<Integer>();
		ArrayList<String> fighterWinners = new ArrayList<String>();
		ArrayList<String> ownerWinners = new ArrayList<String>();
		
		for (Map row : rows) {
			matches.add(Integer.parseInt(String.valueOf(row.get("match_number"))));
			fighterWinners.add(String.valueOf(row.get("character_winner")));
			ownerWinners.add(String.valueOf(row.get("owner_winner")));
		}

		yearObj.setMatches(matches);
		yearObj.setFighterWinners(fighterWinners);
		yearObj.setOwnerWinners(ownerWinners);
		
		return yearObj;
	}
	
	public void updateWinningFighterForMatch(int year, String fighter, int match) {
		String yearTable = "YEAR" + year;
		String sql = "UPDATE " + yearTable + " SET CHARACTER_WINNER = ? WHERE MATCH_NUMBER = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter, match });
	}
	
	public void updateWinningOwnerForMatch(int year, String owner, int match) {
		String yearTable = "YEAR" + year;
		String sql = "UPDATE " + yearTable + " SET OWNER_WINNER = ? WHERE MATCH_NUMBER = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner, match });
	}
	
	public void createNewYear(int year) {
		String yearTable = "YEAR" + year;
		String sql = "CREATE TABLE " + yearTable + " (`match` int(11) NOT NULL,`character_winner` text,`owner_winner` char(1) DEFAULT NULL,PRIMARY KEY (`match`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql);
	}
	
	public void createNewYearColumns(int year) {
		String yearPrefix = "year" + year;
		String sql = "ALTER TABLE FIGHTERS ADD COLUMN `" + yearPrefix + "_owner` TEXT NULL, " +
					"ADD COLUMN `" + yearPrefix + "_wins` INT(11) NULL, " +
					"ADD COLUMN `" + yearPrefix + "_salary` FLOAT NULL";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql);
	}
}
