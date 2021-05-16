package com.example.demo.dto;

import java.math.BigDecimal;

public class DistanceDto {
    String unit;

    BigDecimal distance;

    Location target;

    Location destination;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Location getTarget() {
        return target;
    }

    public void setTarget(Location target) {
        this.target = target;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}

class Location{
    String longitute;

    String latitute;
}
