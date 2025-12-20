package com.vivekkumar.projects.airBnbApp.dto;

import com.vivekkumar.projects.airBnbApp.entity.Guest;
import com.vivekkumar.projects.airBnbApp.entity.Hotel;
import com.vivekkumar.projects.airBnbApp.entity.Room;
import com.vivekkumar.projects.airBnbApp.entity.User;
import com.vivekkumar.projects.airBnbApp.entity.enums.BookingStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingDto {
    Long id;
    Integer roomsCount;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    BookingStatus bookingStatus;
    Set<GuestDto> guests;
}
