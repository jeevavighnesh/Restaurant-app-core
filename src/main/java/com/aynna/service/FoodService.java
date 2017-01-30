package com.aynna.service;

import com.aynna.dao.FoodDAO;
import com.aynna.validator.FoodValidator;

public class FoodService {
	public void deleteService(int id){
		FoodValidator foodval = new FoodValidator();
		FoodDAO fooddao = new FoodDAO();
		boolean valid = foodval.deleteValidator(id);
		if (valid){
			System.out.println("Hai");;
		}
	}
}
