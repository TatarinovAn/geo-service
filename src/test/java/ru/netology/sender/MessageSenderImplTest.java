package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class MessageSenderImplTest {
    @Test
    void test_get_message_russia() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);

        String ip = "172.0.32.11";
        String message = "Добро пожаловать";
        Mockito.when(geoService.byIp(ip))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(message);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        assertEquals(message, messageSender.send(headers));
        System.out.println(); // для ввывода в консоль переноса строки
        assertEquals(message.matches("[а-яёА-ЯЁ]+"), messageSender.send(headers).matches("[а-яёА-ЯЁ]+"));
        System.out.println(); // для ввывода в консоль переноса строки

        assertDoesNotThrow(() -> messageSender.send(headers));

        Mockito.verify(geoService, Mockito.times(3)).byIp(ip);
        System.out.println();
    }

    @Test
    void test_get_message_usa() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        String ip = "96.0.32.11";
        String message = "Welcome";


        Mockito.when(geoService.byIp(ip))
                .thenReturn(new Location("NewYork", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(localizationService.locale(Country.USA)).thenReturn(message);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<String, String>();

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);

        assertEquals(message, messageSender.send(headers));
        System.out.println();

        assertNotEquals(message.matches("[а-яёА-ЯЁ]+"), messageSender.send(headers).matches("^[a-zA-Z]+$"));
        System.out.println(); // для ввывода в консоль переноса строки


        assertDoesNotThrow(() -> messageSender.send(headers));

        Mockito.verify(geoService, Mockito.times(3)).byIp(ip);
        System.out.println();

    }


}