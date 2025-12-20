package com.vivekkumar.projects.airBnbApp.repository;

import com.vivekkumar.projects.airBnbApp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookingrepository extends JpaRepository<Booking, Long> {
}
