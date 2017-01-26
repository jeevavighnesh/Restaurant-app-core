package com.aynna.model;

import lombok.Data;

@Data
public class FoodToSessionMap {//FOODTOTYPEMAP
	int id, quantity;
	Food food;
	Session session;
}
