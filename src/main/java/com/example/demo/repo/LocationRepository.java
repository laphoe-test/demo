package com.example.demo.repo;

import com.example.demo.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Optional<Location> findByPostcode(String postcode);
}
