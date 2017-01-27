package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Seat;
import com.aynna.model.SeatStatus;
import com.aynna.util.ConnectionUtil;

public class SeatDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Seat seat) {

		String sql = "insert into CONFIGURATION(ID,STATUSID,CONCURRENCY) values(?,?,?)";
		Object[] params = { seat.getId(), seat.getSeatStatus().getId(), seat.getConcurrency() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateSeatStatus(Seat seat) {
		String sql = "update SEAT set STATUSID=? where CONCURRENCY=?";
		Object[] params = { seat.getSeatStatus().getId(), seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void updateConcurrency(Seat seat) {

		String sql = "update SEAT set CONCURRENCY=? where ID=?";
		Object[] params = { seat.getConcurrency(), seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from SEAT where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<Seat> list() {//Select All

		String sql = "select ID,STATUSID,CONCURRENCY from SEAT";
		List<Seat> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Seat seat = convert(rs);
			return seat;
		});
		return list;

	}
	
	static Seat convert(ResultSet rs) throws SQLException {
		Seat seat = new Seat();
		SeatStatus seatStatus = new SeatStatus();
		seatStatus.setId(rs.getInt("STATUSID"));
		seat.setId(rs.getInt("ID"));
		seat.setConcurrency(rs.getInt("CONCURRENCY"));
		seat.setSeatStatus(seatStatus);
		return seat;
	}
}
