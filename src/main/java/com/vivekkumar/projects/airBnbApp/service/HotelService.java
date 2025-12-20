package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.HotelDto;
import com.vivekkumar.projects.airBnbApp.dto.HotelInfoDto;
import org.jspecify.annotations.Nullable;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    Void deleteHotelById(Long id);

    void adtivateHotel(Long hotelId);

    HotelInfoDto getHotelInfo(Long hotelId);
}
