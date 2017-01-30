package com.aynna.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.aynna.util.ConnectionUtil;

public class ProcedureSuborderSplitterDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public String subOrderSplitter(String orders, int seatNo) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_SUBORDER_SPLITTER")
                .declareParameters(new SqlParameter("ORDERS", Types.VARCHAR),
                        new SqlParameter("SEATNO", Types.INTEGER),
                        new SqlOutParameter("COMMENTS", Types.VARCHAR));
        call.setAccessCallParameterMetaData(false);
        SqlParameterSource in = new MapSqlParameterSource().addValue("ORDERS", orders).addValue("SEATNO", seatNo);
        Map<String, Object> execute = call.execute(in);
        return(String) execute.get("COMMENTS"); 
    }
}
