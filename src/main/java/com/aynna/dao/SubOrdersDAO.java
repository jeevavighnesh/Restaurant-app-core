package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Food;
import com.aynna.model.Orders;
import com.aynna.model.SubOrders;
import com.aynna.util.ConnectionUtil;

public class SubOrdersDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SubOrders subOrders) {

		String sql = "insert into SUBORDERS (ID,ORDERSID,FOODID,QTY) values(?,?,?,?)";
		Object[] params = { subOrders.getId(), subOrders.getOrders().getId(), subOrders.getFood().getId(),
				subOrders.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateOrdersId(SubOrders subOrders) {

		String sql = "update SUBORDERS set ORDERSID =? where ID=?";
		Object[] params = { subOrders.getOrders().getId(), subOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateFoodId(SubOrders subOrders) {

		String sql = "update SUBORDERS set FOODID =? where ID=?";
		Object[] params = { subOrders.getFood().getId(), subOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateQuantity(SubOrders subOrders) {

		String sql = "update SUBORDERS set QTY =? where ID=?";
		Object[] params = { subOrders.getQuantity(), subOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from SUBORDERS where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<SubOrders> list() {// Select All

		String sql = "select ID,ORDERSID,FOODID,QTY from SUBORDERS";
		List<SubOrders> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			SubOrders subOrders = convert(rs);
			return subOrders;
		});
		return list;

	}

	static SubOrders convert(ResultSet rs) throws SQLException {
		SubOrders subOrders = new SubOrders();
		Orders orders = new Orders();
		orders.setId(rs.getInt("ORDERSID"));
		Food food = new Food();
		food.setId(rs.getInt("FOODID"));
		subOrders.setId(rs.getInt("ID"));
		subOrders.setOrders(orders);
		subOrders.setFood(food);
		subOrders.setQuantity(rs.getInt("QTY"));
		return subOrders;
	}
}
