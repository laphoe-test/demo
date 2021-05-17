package com.example.demo.controller;

import com.example.demo.dto.DistanceDto;
import com.example.demo.service.GeographicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/geographic")
public class GeographicController {
    private static final Logger logger = LoggerFactory.getLogger(GeographicController.class.getName());


    @Autowired
    GeographicService geographicService;

    @GetMapping("/distance/{target}/{destination}")
    public ResponseEntity<DistanceDto> getDistance(@PathVariable String target, @PathVariable String destination) {
        logger.trace("calculate distance from target: {} to destination: {}",target,destination);
        return ResponseEntity.ok().body(geographicService.calcDistance(target,destination));
    }
}
