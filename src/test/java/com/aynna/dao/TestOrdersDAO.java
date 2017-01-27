package com.aynna.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aynna.model.Orders;
import com.aynna.model.Seat;

public class TestOrdersDAO {
	public static void main(String[] args) {
		// Orders orders = new Orders();
		// Seat seat = new Seat();
		// LocalDateTime localdatetime = LocalDateTime.now();
		// String sqltimestampformat =
		// localdatetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd
		// HH:MM:ss"));// Using
		// this
		// for
		// now
		// need
		// to
		// research
		// on
		// parsing
		// a
		// bit
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
		// HH:MM:ss");
		// LocalDateTime sqltimestamp = LocalDateTime.parse(sqltimestampformat,
		// formatter);
		// System.out.println(sqltimestamp);
		// seat.setId(6);
		// orders.setId(15);
		// orders.setNumberOfItems(5);
		// orders.setSeat(seat);
		// orders.setTimeAndDate(sqltimestampformat);// After research is done
		// change variable name here
		//

		OrdersDAO ordersDAO = new OrdersDAO();

		// ordersDAO.save(orders);
		// ordersDAO.delete(15);
		// ordersDAO.updateNumberOfItems(orders);
		// ordersDAO.updateOrdersStatus(orders);
		// ordersDAO.updateSeatId(orders);
		// ordersDAO.updateTimeAndDate(orders);
		List<Orders> configlist = ordersDAO.list();

		for (Orders c : configlist) {
			System.out.println(c);
		}

	}
}
