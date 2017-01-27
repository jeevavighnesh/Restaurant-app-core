package com.aynna.model;

import lombok.Data;

@Data
public class SubOrders {//SUBORDERS
	int id, quantity;
	Orders orders;
	Food food;
}
