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
	
	// update the wins column for the specified owner and year
	public void updateWinsByYear(Owner owner, int year) {
			
		String columnName = "YEAR" + year + "_WINS";
		String sql = "UPDATE OWNERS SET " + columnName + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner.getWinsThroughTheYears().get(year - 1), owner.getName() });
	}
	
	// update the total salary column for the specified owner and year
	public void updateTotalSalaryByYear(Owner owner, int year) {
					
		String columnName = "YEAR" + year + "_TOTAL_SALARY";
		String sql = "UPDATE OWNERS SET " + columnName + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner.getSalariesThroughTheYears().get(year - 1), owner.getName() });
	}
	
	// update the salary remaining column for the specified owner and year
	public void updateSalaryRemainingByYear(Owner owner, int year) {
						
		String columnName = "YEAR" + year + "_SALARY_REMAINING";
		String sql = "UPDATE OWNERS SET " + columnName + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner.getSalariesThroughTheYears().get(year - 1), owner.getName() });
	}
	
	// update the lineup column for the specified owner and year
	public void updateLineupByYear(Owner owner, int year) {
							
		String columnName = "YEAR" + year + "_LINEUP";
		String sql = "UPDATE OWNERS SET " + columnName + " = ? WHERE NAME = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(sql, new Object[] { owner.getLineupsThroughTheYears().get(year - 1), owner.getName() });
	}
}
