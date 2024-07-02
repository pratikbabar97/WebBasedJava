package com.reserve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserve.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
