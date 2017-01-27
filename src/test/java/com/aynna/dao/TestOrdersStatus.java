package com.aynna.dao;

import java.util.List;

import com.aynna.model.OrdersStatus;

public class TestOrdersStatus {
	public static void main(String[] args) {
		// OrdersStatus ordersStatus = new OrdersStatus();
		// ordersStatus.setId(3);
		// ordersStatus.setOrdersStatus("ORDERED");

		OrdersStatusDAO ordersStatusDAO = new OrdersStatusDAO();
		// ordersStatusDAO.save(ordersStatus);
		// ordersStatusDAO.delete(2);
		// ordersStatusDAO.updateOrdersStatus(ordersStatus);
		List<OrdersStatus> configlist = ordersStatusDAO.list();

		for (OrdersStatus c : configlist) {
			System.out.println(c);
		}

	}
}
