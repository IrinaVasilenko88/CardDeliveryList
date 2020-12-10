package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryListTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldRegister() {
        $("[data-test-id=city] input").setValue("Ка");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_YEAR, 3);
        String string = sdf.format(cal.getTime());
        $("[placeholder='Дата встречи']").clear();
        $("[placeholder='Дата встречи']").setValue(string);
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(withText("Успешно!")).waitUntil(visible, 15000);

    }

}
