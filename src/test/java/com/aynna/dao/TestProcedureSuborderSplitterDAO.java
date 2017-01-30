package com.aynna.dao;

public class TestProcedureSuborderSplitterDAO {
	public static void main(String[] args) {
		ProcedureSuborderSplitterDAO pssd = new ProcedureSuborderSplitterDAO();
		String status = pssd.subOrderSplitter("Idly 3,POORI 5", 1);
		System.out.println(status);
	}
}
