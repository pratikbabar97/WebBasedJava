package com.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reserve.dto.ApiResponse;
import com.reserve.entities.Reservation;
import com.reserve.exceptions.ResourceNotFoundException;
import com.reserve.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation createReservation(Reservation reserve) {
		
		return reservationRepository.save(reserve);
	}

	@Override
	public ApiResponse deleteReservation(Long id) {
		Reservation reservation=reservationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("invalid id"));
		
	reservationRepository.delete(reservation);
	return new ApiResponse("rservation deleted");
	}

}
