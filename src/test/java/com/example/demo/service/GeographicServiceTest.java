package com.example.demo.service;

import com.example.demo.BaseTest;
import com.example.demo.constant.ErrorCode;
import com.example.demo.dto.DistanceDto;
import com.example.demo.entity.Location;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repo.LocationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class GeographicServiceTest extends BaseTest {
    @Mock
    LocationRepository mockLocationRepository;

    @InjectMocks
    GeographicService geographicService;

    @Test
    void testCalcDistance() {
        Location target = new Location();
        target.setLatitude(57.144165);
        target.setLongitude(-2.114848);
        target.setPostcode("AB10 1XG");


        Location destination = new Location();
        destination.setLatitude(57.137880);
        destination.setLongitude(-2.121487);
        destination.setPostcode("AB10 6RN");

        when(mockLocationRepository.findByPostcode("AB10 1XG")).thenReturn(Optional.of(target));
        when(mockLocationRepository.findByPostcode("AB10 6RN")).thenReturn(Optional.of(destination));
        DistanceDto dto = geographicService.calcDistance("AB10 1XG", "AB10 6RN");

        assertNotNull(dto);
        assertEquals("KM", dto.getUnit());
        assertEquals(0.8055046803242125, dto.getDistance());
    }

    @Test
    void testCalcDistanceLocationNotFound() {

        when(mockLocationRepository.findByPostcode(anyString())).thenReturn(Optional.empty());

        try {
            geographicService.calcDistance("AB10 1XG", "AB10 6RN");
            fail();
        }catch (ApplicationException ex){
            assertEquals(ErrorCode.POSTCODE_NOT_FOUND, ex.getErrorCode());
        }

    }
}