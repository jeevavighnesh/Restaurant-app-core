package com.aynna.model;

import lombok.Data;

@Data
public class Seat {//SEAT
	int id, concurrency;
	SeatStatus seatStatus;
}
