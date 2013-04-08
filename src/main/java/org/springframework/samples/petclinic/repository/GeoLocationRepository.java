package org.springframework.samples.petclinic.repository;

import org.springframework.samples.petclinic.model.GeoLocation;

public interface GeoLocationRepository {

    void storeLocation(GeoLocation geoLocation);
}
