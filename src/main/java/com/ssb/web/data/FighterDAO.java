package com.ssb.web.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Fighter;
import com.ssb.web.utils.DatabaseUtils;

public class FighterDAO {
	
	@Autowired
	private DataSource dataSource;	
	
	@SuppressWarnings({ "unchecked" })
	public Fighter findByName(String name){
		 
		String sql = "SELECT * FROM FIGHTERS WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 		
		Fighter fighter = (Fighter) jdbcTemplate.queryForObject(sql, new Object[] { name }, new FighterRowMapper());
	 
		return fighter;
	}
	
	public void updateCareerWins(Fighter fighter){
		 
		String sql = "UPDATE FIGHTERS SET CAREER_WINS = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getCareerWins(), fighter.getName() });
	}
	
	public Integer getWinsByYear(int year, String name) {		
		
		String yearString = DatabaseUtils.getYearColumn(year);
		String sql = "SELECT " + yearString + " FROM FIGHTERS WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		Integer wins = (Integer) jdbcTemplate.queryForObject(sql, new Object[] { name }, Integer.class);
		
		return wins;
	}
		
	public void updateWinsByYear(int year, int wins, String name) {
		
		String yearString = DatabaseUtils.getYearColumn(year);
		String sql = "UPDATE FIGHTERS SET " + yearString + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { wins, name });
	}
	
}
