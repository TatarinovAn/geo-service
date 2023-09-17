package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localizationServiceTest() {
        String message = "Hola";

        LocalizationServiceImpl localizationService = Mockito.spy(new LocalizationServiceImpl());

        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Hola");

        assertEquals(message, localizationService.locale(Country.BRAZIL));
    }

}