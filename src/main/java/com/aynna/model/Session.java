package com.aynna.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Session {// TYPEOFFOOD
	int id;
	String name;
	LocalTime start;
	LocalTime end;
}
