package com.example.demo.controller;

import com.example.demo.constant.ErrorCode;
import com.example.demo.dto.LocationDto;
import com.example.demo.entity.Location;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/management")
public class LocationManagementController {
    @Autowired
    LocationRepository locationRepository;

    @GetMapping("location/{postcode}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable String postcode) {
        return ResponseEntity.ok(
                locationRepository.findByPostcode(postcode).map(
                        location -> LocationDto.builder.setLatitute(location.getLatitude()).setLongitute(location.getLongitude())
                                .setPostcode(location.getPostcode()).build()
                ).orElseThrow(() -> new ApplicationException(ErrorCode.POSTCODE_NOT_FOUND))
        );
    }

    @PostMapping("location")
    public ResponseEntity<Object> createLocation(@RequestBody LocationDto dto) {
        Location location = new Location();
        location.setPostcode(dto.getPostcode());
        location.setLongitude(dto.getLongitute());
        location.setLatitude(dto.getLatitute());
        locationRepository.save(location);
        return ResponseEntity.ok().build();
    }
}
