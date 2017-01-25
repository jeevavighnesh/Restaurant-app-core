package com.aynna.model;

import java.sql.Time;

import lombok.Data;

@Data
public class Session {// TYPEOFFOOD
	int id;
	String name;
	Time start;
	Time end;
}
