package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.HotelDto;
import com.vivekkumar.projects.airBnbApp.dto.HotelSearchRequest;
import com.vivekkumar.projects.airBnbApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
