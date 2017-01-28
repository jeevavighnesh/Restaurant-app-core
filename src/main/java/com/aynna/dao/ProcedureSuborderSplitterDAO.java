package com.aynna.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProcedureSuborderSplitterDAO {
	public String checkMenuAvailability(String Orders) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_SUBORDER_SPLITTER")
                .declareParameters(new SqlParameter("ORDERS", Types.VARCHAR),
                        new SqlParameter("SEATNO", Types.INTEGER));
        call.setAccessCallParameterMetaData(false);
        SqlParameterSource in = new MapSqlParameterSource().addValue("ORDERS", Orders);
        Map<String, Object> execute = call.execute(in);
        String Status = (String) execute.get("out_status");
        return Status;
 
    }
}
