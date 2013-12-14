package com.ssb.web.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Fighter;

public class FighterDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public void updateWins(Fighter fighter){
		 
		String sql = "UPDATE FIGHTERS " + "SET WINS = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { fighter.getCareerWins(), fighter.getName() });
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fighter findByName(String name){
		 
		String sql = "SELECT * FROM FIGHTERS WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 		
		Fighter fighter = (Fighter) jdbcTemplate.queryForObject(sql, new Object[] { name }, new BeanPropertyRowMapper(Fighter.class));
	 
		return fighter;
	}
}
