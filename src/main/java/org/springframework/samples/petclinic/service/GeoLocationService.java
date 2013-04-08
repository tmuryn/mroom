package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.GeoLocation;

public interface GeoLocationService {

    public void saveLocation(GeoLocation geoLocation);
}
