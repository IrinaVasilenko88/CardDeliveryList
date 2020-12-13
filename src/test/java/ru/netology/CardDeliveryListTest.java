package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryListTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldRegister() {
        $("[data-test-id=city] input").setValue("Во");
        $(byText("Волгоград")).click();
        $("[data-test-id=date] [value]").click();
        LocalDate dateDefault = LocalDate.now().plusDays(3);
        LocalDate dateOfMeeting = LocalDate.now().plusDays(30);
        String stringToSearch = dateOfMeeting.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String dayToSearch = String.valueOf(dateOfMeeting.getDayOfMonth());
        if (dateOfMeeting.getMonthValue()>dateDefault.getMonthValue()|dateOfMeeting.getYear()>dateDefault.getYear()){
            $(".calendar__arrow_direction_right[data-step='1']").click();
        }
        $$("td.calendar__day").find(exactText(dayToSearch)).click();
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=notification]").waitUntil(Condition.visible, 15000)
                .shouldHave(exactText("Успешно! Встреча успешно забронирована на " + stringToSearch));


    }
    @Test
    void shouldRegisterIfDateIsMoreThanTwoMonths() {
        $("[data-test-id=city] input").setValue("Во");
        $(byText("Волгоград")).click();
        $("[data-test-id=date] [value]").click();
        LocalDate dateDefault = LocalDate.now().plusDays(3);
        LocalDate dateOfMeeting = LocalDate.now().plusDays(50);
        String stringToSearch = dateOfMeeting.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String dayToSearch = String.valueOf(dateOfMeeting.getDayOfMonth());
        if (dateOfMeeting.getMonthValue()>dateDefault.getMonthValue()|dateOfMeeting.getYear()>dateDefault.getYear()){
            $(".calendar__arrow_direction_right[data-step='1']").click();
            $(".calendar__arrow_direction_right[data-step='1']").click();
        }
        $$("td.calendar__day").find(exactText(dayToSearch)).click();
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=notification]").waitUntil(Condition.visible, 15000)
                .shouldHave(exactText("Успешно! Встреча успешно забронирована на " + stringToSearch));


    }
    @Test
    void shouldRegisterIfDateIsMoreThanOneYear() {
        $("[data-test-id=city] input").setValue("Во");
        $(byText("Волгоград")).click();
        $("[data-test-id=date] [value]").click();
        LocalDate dateDefault = LocalDate.now().plusDays(3);
        LocalDate dateOfMeeting = LocalDate.now().plusYears(1);
        String stringToSearch = dateOfMeeting.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String dayToSearch = String.valueOf(dateOfMeeting.getDayOfMonth());
        if (dateOfMeeting.getMonthValue()>dateDefault.getMonthValue()|dateOfMeeting.getYear()>dateDefault.getYear()){
            $(".calendar__arrow_direction_right[data-step='12']").click();
        }
        $$("td.calendar__day").find(exactText(dayToSearch)).click();
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+71111111111");
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[data-test-id=notification]").waitUntil(Condition.visible, 15000)
                .shouldHave(exactText("Успешно! Встреча успешно забронирована на " + stringToSearch));


    }

}
