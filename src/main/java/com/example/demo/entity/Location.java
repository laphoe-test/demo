package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="postcodelatlng")
public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    String postcode;

    @Column(nullable = true)
    Double latitude;

    @Column(nullable = true)
    Double longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
