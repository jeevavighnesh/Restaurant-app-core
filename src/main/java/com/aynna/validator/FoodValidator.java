package com.aynna.validator;

import java.util.List;

import com.aynna.dao.FoodDAO;

public class FoodValidator {
	public boolean deleteValidator(int id) {
		boolean flag = false;
		FoodDAO fooddao = new FoodDAO();
		List<Integer> configlist = fooddao.findFoodId();

		for (Integer c : configlist) {
			if (c.equals(id)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
