package org.springframework.samples.petclinic.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.GeoLocation;
import org.springframework.samples.petclinic.service.GeoLocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping(value = "/geo")
public class GeoLocationController {

    private static final String SECRET_TOKEN = "fc1cb109-a056-4bcc-a094-12cae5688bb5";

    @Autowired
    private GeoLocationService geoLocationService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addGeoLocation(@RequestParam("location") String jsonLocation, @RequestParam("token") String token) throws IOException {
        if (SECRET_TOKEN.equals(token)) {
            geoLocationService.saveLocation(new ObjectMapper().readValue(jsonLocation, GeoLocation.class));

        }
    }
}