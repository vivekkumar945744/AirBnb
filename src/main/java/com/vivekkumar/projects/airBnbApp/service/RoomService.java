package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getRoomById(Long roomId);

    Void deleteRoomById(Long roomId);
}
