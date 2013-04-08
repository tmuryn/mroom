package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.GeoLocation;
import org.springframework.samples.petclinic.repository.GeoLocationRepository;
import org.springframework.stereotype.Service;

@Service("geoLocationService")
public class GeoLocationServiceImpl implements GeoLocationService {
    @Autowired
    private GeoLocationRepository geoLocationRepository;

    public void saveLocation(GeoLocation geoLocation) {
        geoLocationRepository.storeLocation(geoLocation);
    }

}
