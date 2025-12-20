package com.vivekkumar.projects.airBnbApp.repository;

import com.vivekkumar.projects.airBnbApp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}