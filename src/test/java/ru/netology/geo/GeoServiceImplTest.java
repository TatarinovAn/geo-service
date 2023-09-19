package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.netology.entity.Country;


class GeoServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"172.0.0.1", "172.0.32.11", "172.00.00.00"})
    void geoServiceSpy(String ip) {
        GeoServiceImpl geo = new GeoServiceImpl();
        Country expected = Country.RUSSIA;
        Country output = geo.byIp(ip).getCountry();
        Assertions.assertEquals(expected, output);
    }
}