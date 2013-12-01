package com.ssb.web.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Fighter;

public class FighterDAO {
	
	@Autowired
	private DataSource dataSource;
 
	public void insert(Fighter fighter){
 
		String sql = "INSERT INTO CHARACTERS " +
			"(NAME, WINS, MATCHES_PLAYED) VALUES (?, ?, ?)";
 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
 
		jdbcTemplate.update(sql, new Object[] { fighter.getName(),
				fighter.getWins(), fighter.getMatchesPlayed()  
		});
	}
	
	public void updateWins(Fighter fighter){
		 
		String sql = "UPDATE CHARACTERS " +
			"SET WINS = ? WHERE NAME = ?";
 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
 
		jdbcTemplate.update(sql, new Object[] { fighter.getWins(),
				fighter.getName()  
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fighter findByName(String name){
		 
		String sql = "SELECT * FROM CHARACTERS WHERE NAME = ?";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		
		Fighter fighter = (Fighter) jdbcTemplate.queryForObject(
				sql, new Object[] { name }, new BeanPropertyRowMapper(Fighter.class));
	 
		return fighter;
	}
}
