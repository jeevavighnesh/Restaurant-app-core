package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Food;
import com.aynna.model.FoodToSessionMap;
import com.aynna.model.Session;
import com.aynna.util.ConnectionUtil;

public class FoodToSessionMapDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(FoodToSessionMap foodtosessionmap) {

		String sql = "insert into FOOD(ID,QTY,FOODID,TYPEID) values(?,?,?,?)";
		Object[] params = { foodtosessionmap.getId(), foodtosessionmap.getQuantity(),
				foodtosessionmap.getFood().getId(), foodtosessionmap.getSession().getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateMapping(FoodToSessionMap foodToSessionMap) {

		String sql = "update FOODTOTYPEMAP set TYPEID=? where ID=?";
		Object[] params = { foodToSessionMap.getSession().getId(), foodToSessionMap.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateQuantity(FoodToSessionMap foodToSessionMap) {

		String sql = "update FOODTOTYPEMAP set QTY=? where ID=?";
		Object[] params = { foodToSessionMap.getQuantity(), foodToSessionMap.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from FOODTOTYPEMAP where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<FoodToSessionMap> list() {// Select All

		String sql = "select ID,FOODID,TYPEID,QTY FROM FOODTOTYPEMAP";
		List<FoodToSessionMap> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodToSessionMap food = convert(rs);
			return food;
		});
		return list;

	}

	static FoodToSessionMap convert(ResultSet rs) throws SQLException {
		FoodToSessionMap foodToSessionMap = new FoodToSessionMap();
		Food food = new Food();
		Session session = new Session();
		food.setId(rs.getInt("FOODID"));
		session.setId(rs.getInt("TYPEID"));
		foodToSessionMap.setId(rs.getInt("ID"));
		foodToSessionMap.setFood(food);
		foodToSessionMap.setSession(session);
		foodToSessionMap.setQuantity(rs.getInt("QTY"));
		return foodToSessionMap;
	}
}
