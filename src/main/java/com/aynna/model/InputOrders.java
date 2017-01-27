package com.aynna.model;

import lombok.Data;

@Data
public class InputOrders {//INPUTORDERS
	int id;
	int quantity;
	String foodName;
	Seat seat;
	boolean valid;
}
