package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.GeoLocation;
import org.springframework.samples.petclinic.repository.GeoLocationRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.samples.petclinic.repository.jdbc.JdbcGeoLocationRepositoryImpl.TableInfo.*;

import javax.sql.DataSource;

@Repository("geoLocationRepository")
public class JdbcGeoLocationRepositoryImpl implements GeoLocationRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertLocation;

    @Autowired
    public JdbcGeoLocationRepositoryImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertLocation = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    public void storeLocation(GeoLocation geoLocation) {
        this.insertLocation.execute(createLocationParameterSource(geoLocation));
    }

    private MapSqlParameterSource createLocationParameterSource(GeoLocation geoLocation) {
        return new MapSqlParameterSource().
                addValue(GEO_LOCATION, geoLocation.getGeoLocation()).
                addValue(LOCATION_NAME, geoLocation.getLocationName());
    }

    protected static final class TableInfo {
        //Table info
        protected static final String TABLE_NAME = "geo_location";

        //Fields info
        protected static final String GEO_LOCATION = "location";
        protected static final String LOCATION_NAME = "location_name";
    }
}
