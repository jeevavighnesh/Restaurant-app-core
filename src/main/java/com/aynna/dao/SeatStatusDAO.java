package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.SeatStatus;
import com.aynna.util.ConnectionUtil;

public class SeatStatusDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeatStatus seatStatus) {

		String sql = "insert into SEATSTATUS (ID,SEATSTATUS) values(?,?)";
		Object[] params = { seatStatus.getId(), seatStatus.getSeatStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateSeatStatus(SeatStatus seatStatus) {

		String sql = "update SEATSTATUS set STATUSID=? where ID=?";
		Object[] params = { seatStatus.getSeatStatus(), seatStatus.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "delete from SEATSTATUS where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<SeatStatus> list() {//Select All

		String sql = "select ID,SEATSTATUS from SEATSTATUS";
		List<SeatStatus> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeatStatus seatStatus = convert(rs);
			return seatStatus;
		});
		return list;

	}
	
	static SeatStatus convert(ResultSet rs) throws SQLException {
		SeatStatus seatStatus = new SeatStatus();
		seatStatus.setId(rs.getInt("ID"));
		seatStatus.setSeatStatus(rs.getString("SEATSTATUS"));
		return seatStatus;
	}
}
