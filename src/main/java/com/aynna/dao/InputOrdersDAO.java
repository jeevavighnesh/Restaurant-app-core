package com.aynna.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aynna.util.ConnectionUtil;

public class InputOrdersDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
}
