package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Food;
import com.aynna.util.ConnectionUtil;

public class FoodDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Food food) {

		String sql = "insert into FOOD(ID,FOODNAME,PRICE) values(?,?,?)";
		Object[] params = { food.getId(), food.getName(), food.getPrice() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateName(Food food) {

		String sql = "update FOOD set FOODNAME=? where ID=?";
		Object[] params = { food.getName(), food.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updatePrice(Food food) {

		String sql = "update FOOD set PRICE=? where ID=?";
		Object[] params = { food.getPrice(), food.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from FOOD where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<Food> list() {// Select All

		String sql = "select Id,FOODNAME,PRICE from FOOD";
		List<Food> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Food food = convert(rs);
			return food;
		});
		return list;

	}

	static Food convert(ResultSet rs) throws SQLException {
		Food food = new Food();
		food.setId(rs.getInt("ID"));
		food.setName(rs.getString("FOODNAME"));
		food.setPrice(rs.getInt("PRICE"));
		return food;
	}
}
