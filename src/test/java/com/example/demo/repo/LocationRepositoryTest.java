package com.example.demo.repo;

import com.example.demo.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class LocationRepositoryTest extends BaseTest {

    @Autowired
    LocationRepository locationRepository;

    @Test
    void findByPostcode() {
        assertTrue(locationRepository.findByPostcode("AB10 1XG").isPresent());
    }
}