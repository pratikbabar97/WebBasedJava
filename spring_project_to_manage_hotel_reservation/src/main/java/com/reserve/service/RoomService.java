package com.reserve.service;

import java.util.List;

import com.reserve.entities.Room;

public interface RoomService {

	public List<Room> getAvailableRoom(String available);

}