package com.example.demo.controller;

import com.example.demo.dto.DistanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/api/geographic")
public class GeographicController {

    @GetMapping("/distance/{target}/{destination}")
    public ResponseEntity<DistanceDto> getDistance(@PathVariable String target, @PathVariable String destination) {
        return ResponseEntity.ok().body(new DistanceDto());
    }
}
