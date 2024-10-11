package com.sanjeevani.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Location {



    private Double latitude;
    private Double longitude;




    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }



    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
