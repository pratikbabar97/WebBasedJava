package com.reserve.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserve.entities.Room;
import com.reserve.repository.RoomRepository;
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public List<Room> getAvailableRoom(String available) {
		List<Room> rooms=new ArrayList<>();
		rooms=roomRepository.findByAvailability(available);
		return rooms;
	}

}
