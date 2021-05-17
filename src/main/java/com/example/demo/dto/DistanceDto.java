package com.example.demo.dto;

import java.io.Serializable;

public class DistanceDto implements Serializable {
    public final static DistanceDtoBuilder builder = new DistanceDtoBuilder();

    String unit;

    Double distance;

    LocationDto target;

    LocationDto destination;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public LocationDto getTarget() {
        return target;
    }

    public void setTarget(LocationDto target) {
        this.target = target;
    }

    public LocationDto getDestination() {
        return destination;
    }

    public void setDestination(LocationDto destination) {
        this.destination = destination;
    }

    public static class DistanceDtoBuilder {
        String unit;

        Double distance;

        LocationDto target;

        LocationDto destination;

        public DistanceDtoBuilder setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public DistanceDtoBuilder setDistance(Double distance) {
            this.distance = distance;
            return this;
        }

        public DistanceDtoBuilder setTarget(LocationDto target) {
            this.target = target;
            return this;
        }

        public DistanceDtoBuilder setDestination(LocationDto destination) {
            this.destination = destination;
            return this;
        }

        public DistanceDto build(){
            DistanceDto dto = new DistanceDto();
            dto.setUnit(unit);
            dto.setDestination(destination);
            dto.setTarget(target);
            dto.setDistance(distance);
            return dto;
        }
    }

}