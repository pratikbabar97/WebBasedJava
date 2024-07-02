package com.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.entities.Reservation;
import com.reserve.entities.Room;
import com.reserve.service.ReservationService;
@RestController
@RequestMapping
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	public ResponseEntity<?>createReservation(@RequestBody Reservation reserve){
		return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(reserve));	
	}
	
	@DeleteMapping("/{rid}")
	public ResponseEntity<?> deleteReservation(@PathVariable Long rid){
		return ResponseEntity.ok(reservationService.deleteReservation(rid));
		
	}

}
