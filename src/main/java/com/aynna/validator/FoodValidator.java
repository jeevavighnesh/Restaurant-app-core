package com.aynna.validator;

import java.util.List;

import com.aynna.dao.FoodDAO;
import com.aynna.exception.ItemNotFound;
import com.aynna.model.Food;

public class FoodValidator {
	public boolean deleteValidator(int id) {
		boolean flag = false;
		FoodDAO fooddao = new FoodDAO();
		List<Food> configlist = fooddao.list();

		for (Food c : configlist) {
			if(c.getId() == id){
				flag = true;
				break;
			}
		}
		if (!flag)
			try {
				throw new ItemNotFound("That Id is not in the list Bruh!!!!");
			} catch (ItemNotFound e) {
				e.printStackTrace();
			}
		return flag;
	}
}
