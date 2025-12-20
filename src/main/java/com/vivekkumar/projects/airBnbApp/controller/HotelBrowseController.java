package com.vivekkumar.projects.airBnbApp.controller;

import com.vivekkumar.projects.airBnbApp.dto.HotelDto;
import com.vivekkumar.projects.airBnbApp.dto.HotelInfoDto;
import com.vivekkumar.projects.airBnbApp.dto.HotelSearchRequest;
import com.vivekkumar.projects.airBnbApp.service.HotelService;
import com.vivekkumar.projects.airBnbApp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfo(hotelId));
    }
}
