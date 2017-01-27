package com.aynna.dao;

import java.util.List;

import com.aynna.model.Seat;

public class TestSeatDAO {
	public static void main(String[] args) {
		// Seat seat = new Seat();
		// seat.setId(1);
		// seat.setStatusId(1);
		// seat.setConcurrency(0);
		//
		SeatDAO seatDao = new SeatDAO();
		// seatDao.save(seat);
		// seatDao.delete(10);
		// seatDao.updateSeatStatus(seat);
		// seatDao.updateConcurrency(seat);
		List<Seat> seats = seatDao.list();

		for (Seat c : seats) {
			System.out.println(c);
		}

	}
}
