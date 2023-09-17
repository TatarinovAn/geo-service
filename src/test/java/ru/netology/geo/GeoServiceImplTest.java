package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    @Test
    void geoServiceSpy() {
        String ip = "96.0.32.11";

        GeoService geoService = Mockito.spy(new GeoServiceImpl());

        Mockito.when(geoService.byIp(ip)).thenReturn(new Location("Piter", Country.BRAZIL, null, 0));

        Location location = geoService.byIp(ip);

        assertEquals(location.getCountry(), Country.BRAZIL);
    }
}