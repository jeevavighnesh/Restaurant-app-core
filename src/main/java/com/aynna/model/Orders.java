package com.aynna.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Orders {//ORDERS
	int id, numberOfItems, seatId;
	boolean orderStatus;
	Timestamp timeAndDate;
}
