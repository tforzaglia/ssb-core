package com.ssb.web.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssb.web.model.Owner;

public class OwnerDAO {

	@Autowired
	private DataSource dataSource;	
	
	// retrieve all data related to the specified owner from the database
	@SuppressWarnings({ "unchecked" })
	public Owner findByName(String name){
		 
		String sql = "SELECT * FROM OWNERS WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 		
		Owner owner = (Owner) jdbcTemplate.queryForObject(sql, new Object[] { name }, new OwnerRowMapper());
	 
		return owner;
	}
	
	// update the career wins column of the owners table for the specified owner
	public void updateCareerWins(Owner owner){
			 
		String sql = "UPDATE OWNERS SET CAREER_WINS = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner.getCareerWins(), owner.getName() });
	}
	
	
}
