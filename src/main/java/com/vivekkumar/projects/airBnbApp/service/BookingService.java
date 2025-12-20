package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.BookingDto;
import com.vivekkumar.projects.airBnbApp.dto.BookingRequest;
import com.vivekkumar.projects.airBnbApp.dto.GuestDto;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    @Nullable BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
