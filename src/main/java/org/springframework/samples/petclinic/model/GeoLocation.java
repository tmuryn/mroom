package org.springframework.samples.petclinic.model;


public class GeoLocation {
    private String geoLocation;
    private String locationName;

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoLocation that = (GeoLocation) o;

        if (!geoLocation.equals(that.geoLocation)) return false;
        if (!locationName.equals(that.locationName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = geoLocation.hashCode();
        result = 31 * result + locationName.hashCode();
        return result;
    }
}
