package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.HotelDto;
import com.vivekkumar.projects.airBnbApp.entity.Hotel;

public interface HodelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);
}
