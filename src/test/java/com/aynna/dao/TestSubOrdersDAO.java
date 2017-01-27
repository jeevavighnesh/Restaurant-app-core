package com.aynna.dao;

import java.time.LocalTime;
import java.util.List;

import com.aynna.model.Food;
import com.aynna.model.Orders;
import com.aynna.model.SubOrders;

public class TestSubOrdersDAO {
	public static void main(String[] args) {
		// Orders orders = new Orders();
		// Food food = new Food();
		// orders.setId(1);
		// food.setId(2);
		// SubOrders subOrders = new SubOrders();
		// subOrders.setId(1);
		// subOrders.setFood(food);
		// subOrders.setOrders(orders);
		// subOrders.setQuantity(3);

		SubOrdersDAO subOrdersDao = new SubOrdersDAO();
		// subOrdersDao.save(subOrders);
		// subOrdersDao.delete(5);
		// subOrdersDao.updateFoodId(subOrders);
		// subOrdersDao.updateOrdersId(subOrders);
		// subOrdersDao.updateQuantity(subOrders);
		List<SubOrders> subOrders2 = subOrdersDao.list();

		for (SubOrders c : subOrders2) {
			System.out.println(c);
		}

	}
}
