package com.reserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserve.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/{available}")
	public ResponseEntity<?> getRooms(@PathVariable String available){
		
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getAvailableRoom(available));
		
	}
	
 
}
