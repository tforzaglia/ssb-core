package com.ssb.web.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Fighter;

public class FighterDAO {
	
	@Autowired
	private DataSource dataSource;	
	
	// retrieve all data related to the specified fighter from the database
	@SuppressWarnings({ "unchecked" })
	public Fighter findByName(String name){
		 
		String sql = "SELECT * FROM FIGHTERS WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 		
		Fighter fighter = (Fighter) jdbcTemplate.queryForObject(sql, new Object[] { name }, new FighterRowMapper());
	 
		return fighter;
	}
	
	// update the career wins column of the fighters table for the specified fighter
	public void updateCareerWins(Fighter fighter){
		 
		String sql = "UPDATE FIGHTERS SET CAREER_WINS = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getCareerWins(), fighter.getName() });
	}
		
	// update the wins column for the specified fighter and year
	public void updateWinsByYear(Fighter fighter, int year) {
		
		String yearString = "YEAR" + year + "_WINS";
		String sql = "UPDATE FIGHTERS SET " + yearString + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getWinsThroughTheYears().get(year - 1), fighter.getName() });
	}
	
	// update the restricted status of the specified fighter
	public void updateRestrictedStatus(Fighter fighter) {
		
		String sql = "UPDATE FIGHTERS SET IS_RESTRICTED = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getIsRestricted(), fighter.getName() });
	}
	
	// update the restricted year for the specified fighter
	public void updateRestrictedYear(Fighter fighter) {
		
		String sql = "UPDATE FIGHTERS SET RESTRICTED_YEAR = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getRestrictedYear(), fighter.getName() });
	}
	
	// update the owner column for the specified fighter and year
	public void updateOwnerByYear(Fighter fighter, int year) {
			
		String yearString = "YEAR" + year + "_OWNER";
		String sql = "UPDATE FIGHTERS SET " + yearString + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getOwnersThroughTheYears().get(year - 1), fighter.getName() });
	}
	
	// update the salary column for the specified fighter and year
	public void updateSalaryByYear(Fighter fighter, int year) {
				
		String yearString = "YEAR" + year + "_SALARY";
		String sql = "UPDATE FIGHTERS SET " + yearString + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getSalariesThroughTheYears().get(year - 1), fighter.getName() });
	}
}
