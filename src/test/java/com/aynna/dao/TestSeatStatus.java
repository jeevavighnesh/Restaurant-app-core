package com.aynna.dao;

import java.util.List;

import com.aynna.model.SeatStatus;

public class TestSeatStatus {
	public static void main(String[] args) {
//		 SeatStatus seatStatus = new SeatStatus();
//		 seatStatus.setId(3);
//		 seatStatus.setSeatStatus("BOOKED");
		
		SeatStatusDAO seatStatusDao = new SeatStatusDAO();
//		 seatStatusDao.save(seatStatus);
//		 seatStatusDao.delete(1);
//		 seatStatusDao.updateSeatStatus(seatStatus);
		List<SeatStatus> seatStatus2 = seatStatusDao.list();

		for (SeatStatus c : seatStatus2) {
			System.out.println(c);
		}

	}
}
