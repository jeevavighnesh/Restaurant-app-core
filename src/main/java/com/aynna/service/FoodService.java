package com.aynna.service;

import com.aynna.dao.FoodDAO;
import com.aynna.exception.ItemNotFound;
import com.aynna.validator.FoodValidator;

public class FoodService {
	public void deleteService(int id) {
		FoodValidator foodval = new FoodValidator();
		FoodDAO fooddao = new FoodDAO();
		boolean valid = foodval.deleteValidator(id);

		if (!valid)
			try {
				throw new ItemNotFound("That Id is not in the list Bruh!!!!");
			} catch (ItemNotFound inf) {
				inf.printStackTrace();
			}
		else
			fooddao.delete(id);
		// System.out.println("hai");
	}
}
