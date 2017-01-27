package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Orders;
import com.aynna.model.Seat;
import com.aynna.util.ConnectionUtil;

public class OrdersDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Orders orders) {

		String sql = "insert into ORDERS(ID,NOOFITEMS,SEATID,ORDERSSTATUS,TIMEANDDATE) values(?,?,?,?,?)";
		Object[] params = { orders.getId(), orders.getNumberOfItems(), orders.getSeat().getId(), orders.isOrderStatus(),
				orders.getTimeAndDate().toLocalTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateNumberOfItems(Orders orders) {

		String sql = "update ORDERS set NOOFITEMS=? where ID=?";
		Object[] params = { orders.getNumberOfItems(), orders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateSeatId(Orders orders) {

		String sql = "update ORDERS set SEATID=? where ID=?";
		Object[] params = { orders.getSeat().getId(), orders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateOrdersStatus(Orders orders) {

		String sql = "update ORDERS set ORDERSSTATUS=? where ID=?";
		Object[] params = { orders.isOrderStatus(), orders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void updateTimeAndDate(Orders orders) {

		String sql = "update ORDERS set TIMEANDDATE=? where ID=?";
		Object[] params = { orders.getTimeAndDate(), orders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from ORDERS where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<Orders> list() {// Select All

		String sql = "select ID,NOOFITEMS,SEATID,ORDERSSTATUS,TIMEANDDATE from ORDERS";
		List<Orders> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Orders orders = convert(rs);
			return orders;
		});
		return list;

	}

	static Orders convert(ResultSet rs) throws SQLException {
		Orders orders = new Orders();
		Seat seat = new Seat();
		seat.setId(rs.getInt("SEATID"));
		orders.setId(rs.getInt("ID"));
		orders.setNumberOfItems(rs.getInt("NOOFITEMS"));
		orders.setSeat(seat);
		orders.setOrderStatus(rs.getBoolean("ORDERSSTATUS"));
		orders.setTimeAndDate(rs.getTimestamp("TIMEANDDATE").toLocalDateTime());
		return orders;
	}
}
