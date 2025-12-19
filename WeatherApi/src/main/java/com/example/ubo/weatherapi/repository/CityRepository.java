package com.example.ubo.weatherapi.repository;

import com.example.ubo.weatherapi.exception.FunctionnalException;
import dto.weatherapi.City;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CityRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CityRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String SQL_INSERT_CITY = "INSERT INTO city "
            + "(id, name, country, departement, region, altitude, latitude, longitude, zipcode) "
            + "VALUES (:id, :name, :country, :department, :region, :altitude, :latitude, :longitude, :zipCode)";

    private final static String SQL_GET_CITY_BY_ID = "SELECT id, name, country, departement, region, altitude, latitude, longitude, zipcode FROM city WHERE id = :id";

    private final static String SQL_GET_CITY_BY_NAME =
            "SELECT id, name, country, departement, region, altitude, latitude, longitude, zipcode " +
                    "FROM city WHERE name = :name";

    public City addCity(City city) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", city.getId());
        params.put("name", city.getName());
        params.put("country", city.getCountry());
        params.put("department", city.getDepartement());  // correspond maintenant à :department
        params.put("region", city.getRegion());
        params.put("altitude", city.getAltitude());
        params.put("latitude", city.getPosition().getLatitude());
        params.put("longitude", city.getPosition().getLongitude());
        params.put("zipCode", city.getZipcode());       // correspond maintenant à :zipCode

        jdbcTemplate.update(SQL_INSERT_CITY, params);
        return city;
    }

    public City getCityByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.queryForObject(SQL_GET_CITY_BY_NAME, params, (rs, rowNum) -> {
            City city = new City();
            city.setId(String.valueOf(rs.getInt("id")));
            city.setName(rs.getString("name"));
            city.setCountry(rs.getString("country"));
            city.setDepartement(rs.getInt("department"));
            city.setRegion(rs.getString("region"));
            city.setAltitude(BigDecimal.valueOf(Long.parseLong(rs.getString("altitude"))));
            city.setZipcode(BigDecimal.valueOf(Long.parseLong(rs.getString("zipCode"))));

            dto.weatherapi.Position position = new dto.weatherapi.Position();
            position.setLatitude((float) rs.getDouble("latitude"));
            position.setLongitude((float) rs.getDouble("longitude"));
            city.setPosition(position);
            return city;
        });
    }


    public City getCityById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        try {
            return jdbcTemplate.queryForObject(SQL_GET_CITY_BY_ID, params, (rs, rowNum) -> {
                City city = new City();
                city.setId(String.valueOf(rs.getInt("id")));
                city.setName(rs.getString("name"));
                city.setCountry(rs.getString("country"));
                city.setDepartement(rs.getInt("departement"));
                city.setRegion(rs.getString("region"));
                city.setAltitude(BigDecimal.valueOf(Long.parseLong(rs.getString("altitude"))));
                city.setZipcode(BigDecimal.valueOf(Long.parseLong(rs.getString("zipcode"))));

                dto.weatherapi.Position position = new dto.weatherapi.Position();
                position.setLatitude((float) rs.getDouble("latitude"));
                position.setLongitude((float) rs.getDouble("longitude"));
                city.setPosition(position);

                return city;
            });

        } catch (Exception e) {
            throw new FunctionnalException(001, "City not found");
        }
    }

}
