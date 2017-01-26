package com.aynna.dao;

import java.util.List;

import com.aynna.model.Food;
import com.aynna.model.FoodToSessionMap;
import com.aynna.model.Session;

public class TestFoodToSessionMapDAO {
	public static void main(String[] args) {
		// FoodToSessionMap foodToSessionMap = new FoodToSessionMap();
		// Food food = new Food();
		// food.setId(1);
		// Session session = new Session();
		// session.setId(4);
		// foodToSessionMap.setId(17);
		// foodToSessionMap.setFood(food);;
		// foodToSessionMap.setSession(session);
		// foodToSessionMap.setQuantity(50);

		FoodToSessionMapDAO foodToSessionMapDAO = new FoodToSessionMapDAO();
		// foodToSessionMapDAO.save(foodToSessionMap);
		// foodToSessionMapDAO.delete(15);
		// foodToSessionMapDAO.updateMapping(foodToSessionMap);
		// foodToSessionMapDAO.updateQuantity(foodToSessionMap);
		List<FoodToSessionMap> configlist = foodToSessionMapDAO.list();

		for (FoodToSessionMap c : configlist) {
			System.out.println(c);
		}

	}
}
