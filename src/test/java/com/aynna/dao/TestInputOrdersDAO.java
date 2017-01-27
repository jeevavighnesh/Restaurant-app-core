package com.aynna.dao;

import java.util.List;

import com.aynna.model.InputOrders;
import com.aynna.model.Seat;

public class TestInputOrdersDAO {
	public static void main(String[] args) {
		// InputOrders inputOrders = new InputOrders();
		// Seat seat = new Seat();
		// seat.setId(6);
		// inputOrders.setId(15);
		// inputOrders.setFoodName("Kabab");
		// inputOrders.setQuantity(5);
		// inputOrders.setSeat(seat);

		InputOrdersDAO inputOrdersDAO = new InputOrdersDAO();
		// inputOrdersDAO.save(inputOrders);
		// inputOrdersDAO.delete(15);
		// inputOrdersDAO.updateFoodName(inputOrders);
		// inputOrdersDAO.updateQuantity(inputOrders);
		// inputOrdersDAO.updateSeatId(inputOrders);
		// inputOrdersDAO.updateValid(inputOrders);
		List<InputOrders> configlist = inputOrdersDAO.list();

		for (InputOrders c : configlist) {
			System.out.println(c);
		}

	}
}
