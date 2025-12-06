package com.vivekkumar.projects.airBnbApp.service;

import com.vivekkumar.projects.airBnbApp.dto.RoomDto;
import com.vivekkumar.projects.airBnbApp.entity.Hotel;
import com.vivekkumar.projects.airBnbApp.entity.Room;
import com.vivekkumar.projects.airBnbApp.exception.ResourceNotFoundException;
import com.vivekkumar.projects.airBnbApp.repository.HotelRepository;
import com.vivekkumar.projects.airBnbApp.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    @Transactional
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating a new room in hotel with Id: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hote not found with ID: " + hotelId));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);

        if (hotel.getActive()) {
            inventoryService.initializeRoomForAYear(room);
        }

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all rooms in hotel with Id: {}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hote not found with ID: " + hotelId));

        return hotel.getRooms()
                .stream().
                map((element) -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("Getting the rooms with Id: {}", roomId);
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + roomId));

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    @Transactional
    public Void deleteRoomById(Long roomId) {
        log.info("Deleting the rooms with Id: {}", roomId);
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + roomId));

        inventoryService.deleteFutureInventories(room);
        roomRepository.deleteById(roomId);
        return null;
    }
}
