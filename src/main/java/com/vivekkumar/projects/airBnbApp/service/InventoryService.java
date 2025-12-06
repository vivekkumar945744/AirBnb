package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);
}
