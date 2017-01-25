package com.aynna.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Configuration;
import com.aynna.util.ConnectionUtil;

public class ConfigurationDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Configuration config) {

		String sql = "insert into CONFIGURATION(ID,ITEMLIMIT,NUMBEROFSEATS) values(?,?,?)";
		Object[] params = { config.getId(), config.getItemLimit(), config.getNumberOfSeats() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateItemLimit(Configuration config) {

		String sql = "update CONFIGURATION set ITEMLIMIT=? where ID=?";
		Object[] params = { config.getItemLimit(), config.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void updateNumberOfSeats(Configuration config) {

		String sql = "update CONFIGURATION set NUMBEROFSEATS=? where ID=?";
		Object[] params = { config.getNumberOfSeats(), config.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from CONFIGURATION where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<Configuration> list() {//Select All

		String sql = "select Id,ITEMLIMIT,NUMBEROFSEATS from CONFIGURATION";
		List<Configuration> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Configuration config = convert(rs);
			return config;
		});
		return list;

	}
	
	static Configuration convert(ResultSet rs) throws SQLException {
		Configuration config = new Configuration();
		config.setId(rs.getInt("ID"));
		config.setItemLimit(rs.getInt("ITEMLIMIT"));
		config.setNumberOfSeats(rs.getInt("NUMBEROFSEATS"));
		return config;
	}
}
