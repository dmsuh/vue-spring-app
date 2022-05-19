package com.devserv.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devserv.hotels.entity.Hotels;
import com.devserv.hotels.links.HotelLinks;
import com.devserv.hotels.service.HotelsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class HotelsController {

	@Autowired
	HotelsService hotelsService;

	@GetMapping(path = HotelLinks.LIST_HOTELS)
    public ResponseEntity<?> listHotels() {
        List<Hotels> resource = hotelsService.getHotels();
        log.info("HotelsController:  list hotels"+resource);
        return ResponseEntity.ok(resource);
    }

	@PostMapping(path = HotelLinks.ADD_HOTEL)
	public ResponseEntity<?> saveHotel(@RequestBody Hotels hotel) {
        log.info("HotelsController:  add hotel");
        Hotels resource = hotelsService.saveHotel(hotel);
        return ResponseEntity.ok(resource);
    }
}
