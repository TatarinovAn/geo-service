package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;


class LocalizationServiceImplTest {

    @Test
    void localizationServiceTest_Russia() {
        LocalizationServiceImpl test = new LocalizationServiceImpl();
        String output = test.locale(RUSSIA);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(output, expected);
    }

    @Test
    void localizationServiceTest_USA() {
        LocalizationServiceImpl test = new LocalizationServiceImpl();
        String output = test.locale(USA);

        String expected = "Welcome";

        Assertions.assertEquals(output, expected);
    }

}