package com.aynna.dao;

import java.util.List;

import com.aynna.model.Food;

public class TestFoodDAO {
	public static void main(String[] args) {
		// Food food = new Food();
		// food.setId(15);
		// food.setName("Soru");
		// food.setPrice(20);

		FoodDAO fooddao = new FoodDAO();
		// fooddao.save(food);
		// fooddao.delete(15);
		// fooddao.updateName(food);
		// fooddao.updatePrice(food);
		List<Food> foodList = fooddao.list();

		for (Food c : foodList) {
			System.out.println(c);
		}
		
		// List<Integer> foodIdList = fooddao.findFoodId();
		//
		// for (Integer c : foodIdList) {
		// System.out.println(c);
		// }
		//
		// List<String> foodNameList = fooddao.findFoodNames();
		//
		// for (String c : foodNameList) {
		// System.out.println(c);
		// }

	}
}
