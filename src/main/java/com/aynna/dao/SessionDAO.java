package com.aynna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.model.Session;
import com.aynna.util.ConnectionUtil;

public class SessionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Session session) {

		String sql = "insert into TYPEOFFOOD (ID,SESSIONNAME,SESSIONSTART,SESSIONEND) values(?,?,?,?)";
		Object[] params = { session.getId(), session.getName(),session.getStart(),session.getEnd() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void updateSessionName(Session session) {

		String sql = "update TYPEOFFOOD set SESSIONNAME =? where ID=?";
		Object[] params = { session.getName(), session.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void updateSessionStart(Session session) {

		String sql = "update TYPEOFFOOD set SESSIONSTART =? where ID=?";
		Object[] params = { session.getStart(), session.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void updateSessionEnd(Session session) {

		String sql = "update TYPEOFFOOD set SESSIONEND =? where ID=?";
		Object[] params = { session.getEnd(), session.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(int id) {

		String sql = "delete from TYPEOFFOOD where ID=?";
		Object[] params = { id };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public List<Session> list() {//Select All

		String sql = "select ID,SESSIONNAME,SESSIONSTART,SESSIONEND from TYPEOFFOOD";
		List<Session> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Session session = convert(rs);
			return session;
		});
		return list;

	}
	
	static Session convert(ResultSet rs) throws SQLException {
		Session session = new Session();
		session.setId(rs.getInt("ID"));
		session.setName(rs.getString("SESSIONNAME"));
		session.setStart(rs.getTime("SESSIONSTART").toLocalTime());
		session.setEnd(rs.getTime("SESSIONEND").toLocalTime());
		return session;
	}
}
