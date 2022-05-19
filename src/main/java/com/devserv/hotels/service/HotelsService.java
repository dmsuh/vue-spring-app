package com.devserv.hotels.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devserv.hotels.entity.Hotels;
import com.devserv.hotels.repository.HotelsRepository;

@Component
public class HotelsService {

	private HotelsRepository hotelsRepository;

    public HotelsService(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    public List<Hotels> getHotels() {
        return hotelsRepository.findAll();
    }

    public Hotels saveHotel(Hotels hotels) {
    	return hotelsRepository.save(hotels);
    }

}
