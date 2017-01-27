package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.InputOrders;
import com.aynna.model.Seat;
import com.aynna.util.ConnectionUtil;

public class InputOrdersDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(InputOrders inputOrders) {

		String sql = "insert into INPUTORDERS(ID,FOOD,QTY,SEATID,VALID) values(?,?,?,?,?)";
		Object[] params = { inputOrders.getId(), inputOrders.getFoodName(), inputOrders.getQuantity(),
				inputOrders.getSeat().getId(), inputOrders.isValid() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateFoodName(InputOrders inputOrders) {

		String sql = "update INPUTORDERS set QTY=? where ID=?";
		Object[] params = { inputOrders.getQuantity(), inputOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateQuantity(InputOrders inputOrders) {

		String sql = "update INPUTORDERS set QTY=? where ID=?";
		Object[] params = { inputOrders.getQuantity(), inputOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateSeatId(InputOrders inputOrders) {

		String sql = "update INPUTORDERS set SEATID=? where ID=?";
		Object[] params = { inputOrders.getSeat().getId(), inputOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateValid(InputOrders inputOrders) {

		String sql = "update INPUTORDERS set VALID=? where ID=?";
		Object[] params = { inputOrders.isValid(), inputOrders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from INPUTORDERS where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<InputOrders> list() {// Select All

		String sql = "select ID,FOOD,QTY,SEATID,VALID from INPUTORDERS";
		List<InputOrders> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			InputOrders inputOrders = convert(rs);
			return inputOrders;
		});
		return list;

	}

	static InputOrders convert(ResultSet rs) throws SQLException {
		InputOrders inputOrders = new InputOrders();
		Seat seat = new Seat();
		seat.setId(rs.getInt("SEATID"));
		inputOrders.setId(rs.getInt("ID"));
		inputOrders.setFoodName(rs.getString("FOOD"));
		inputOrders.setSeat(seat);
		inputOrders.setQuantity(rs.getInt("QTY"));
		inputOrders.setValid(rs.getBoolean("VALID"));
		return inputOrders;
	}
}