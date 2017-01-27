package com.aynna.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Orders {//ORDERS
	int id;
	int numberOfItems;
	Seat seat;
	boolean orderStatus;
	LocalDateTime timeAndDate;
}
