package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Configuration;
import com.aynna.model.OrdersStatus;
import com.aynna.util.ConnectionUtil;

public class OrdersStatusDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(OrdersStatus ordersStatus) {

		String sql = "insert into ORDERSSTATUS(ID,ORDERSSTATUS) values(?,?)";
		Object[] params = { ordersStatus.getId(), ordersStatus.getOrdersStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateOrdersStatus(OrdersStatus ordersStatus) {

		String sql = "update ORDERSSTATUS set ORDERSSTATUS=? where ID=?";
		Object[] params = { ordersStatus.getOrdersStatus(), ordersStatus.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "delete from ORDERSSTATUS where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<OrdersStatus> list() {//Select All

		String sql = "select ID,ORDERSSTATUS from ORDERSSTATUS";
		List<OrdersStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrdersStatus ordersStatus = convert(rs);
			return ordersStatus;
		});
		return list;

	}
	
	static OrdersStatus convert(ResultSet rs) throws SQLException {
		OrdersStatus ordersStatus = new OrdersStatus();
		ordersStatus.setId(rs.getInt("ID"));
		ordersStatus.setOrdersStatus(rs.getString("ORDERSSTATUS"));
		return ordersStatus;
	}
}
