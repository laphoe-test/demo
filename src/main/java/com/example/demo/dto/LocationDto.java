package com.example.demo.dto;

public class LocationDto {
    public final static LocationDtoBuilder builder = new LocationDtoBuilder();

    String postcode;

    Double longitute;

    Double latitute;

    public Double getLongitute() {
        return longitute;
    }

    public void setLongitute(Double longitute) {
        this.longitute = longitute;
    }

    public Double getLatitute() {
        return latitute;
    }

    public void setLatitute(Double latitute) {
        this.latitute = latitute;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public static class LocationDtoBuilder {
        String postcode;

        Double longitute;

        Double latitute;

        public LocationDtoBuilder setLongitute(Double longitute) {
            this.longitute = longitute;
            return this;
        }

        public LocationDtoBuilder setLatitute(Double latitute) {
            this.latitute = latitute;
            return this;
        }

        public LocationDtoBuilder setPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public LocationDto build(){
            LocationDto dto = new LocationDto();
            dto.setLatitute(latitute);
            dto.setLongitute(longitute);
            return dto;
        }
    }
}

