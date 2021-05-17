package com.example.demo.service;

import com.example.demo.constant.ErrorCode;
import com.example.demo.constant.GeographicalConst;
import com.example.demo.dto.DistanceDto;
import com.example.demo.dto.LocationDto;
import com.example.demo.entity.Location;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.example.demo.constant.GeographicalConst.EARTH_RADIUS;

@Service
@Transactional
public class GeographicService {
    @Autowired
    LocationRepository locationRepository;

    public DistanceDto calcDistance(String targetPostcode, String destinationPostcode) {
        Location target = locationRepository.findByPostcode(targetPostcode).orElseThrow(() -> new ApplicationException(ErrorCode.POSTCODE_NOT_FOUND));
        Location destination = locationRepository.findByPostcode(destinationPostcode).orElseThrow(() -> new ApplicationException(ErrorCode.POSTCODE_NOT_FOUND));

        double lon1Radians = Math.toRadians(target.getLongitude());
        double lon2Radians = Math.toRadians(destination.getLongitude());
        double lat1Radians = Math.toRadians(target.getLatitude());
        double lat2Radians = Math.toRadians(destination.getLatitude());
        double a = haversine(lat1Radians, lat2Radians) + Math.cos(lat1Radians) * Math.cos(lat2Radians) * haversine(lon1Radians, lon2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return DistanceDto.builder
                .setDestination(LocationDto.builder.setLatitute(destination.getLatitude()).setLongitute(destination.getLongitude()).build())
                .setTarget(LocationDto.builder.setLatitute(target.getLatitude()).setLongitute(target.getLongitude()).build())
                .setUnit(GeographicalConst.UNIT.KM.name())
                .setDistance(EARTH_RADIUS * c).build();

    }

    private double haversine(double deg1, double deg2) {
        return square(Math.sin((deg1 - deg2) / 2.0));
    }

    private double square(double x) {
        return x * x;
    }
}
