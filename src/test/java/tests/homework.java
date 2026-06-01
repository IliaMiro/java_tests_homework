package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class homework {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "144.0";
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000; // default 4000
    }


    @Test
    void all_fields_Test() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        //Календарь (Уточнить про день) как выбирать день в колендаре, понял как год и месяц (через селектопцию)
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("2024");
        $("[id=dateOfBirthInput]").click();
        $("[id=dateOfBirthInput]").pressEnter();
        //Увлечение
        $("[id=subjectsInput]").setValue("Physics").pressEnter();
        $("[id=subjectsInput]").setValue("Chemistry").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        //Загрузка картинки (не разобрался как подгрузить картинку, я так понял нужно использовать uploadFile и указать путь но не получилось часа 2 гуглил и думал но выдавалась ошибка)
        //$("[id=uploadPicture]").uploadFile();
        $("[id=currentAddress]").setValue("г. Москва Черноморский бульвар");
        // выбор города
        $("#state .css-13cymwt-control").click();
        $(byText("Haryana")).click();
        $("#city .css-13cymwt-control").click();
        $(byText("Karnal")).click();
        $("[id=submit]").click();
    }

    @Test
    void only_with_required_fields() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void the_negative_scenario_1() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("324421");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();

    }

    @Test
    void the_negative_scenario_2() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("dfsfxdvb");
        $("[id=submit]").click();

    }

    @Test
    void the_negative_scenario_3() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void the_negative_scenario_4() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void simple_form_1() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=currentAddress]").setValue("г Москва, б-р Бескудниковский");
        $("[id=permanentAddress]").setValue("г. Москва Черноморский бульвар");
        $("[id=submit]").click();
    }

    @Test
    void simple_form_2() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=currentAddress]").setValue("г Тверь улица тверь дом тверь");
        $("[id=permanentAddress]").setValue("г. Москва улица Кустанайская");
        $("[id=submit]").click();
    }

    @Test
    void simple_minimum_form() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=submit]").click();
    }

    @Test
    void imple_form_negative() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("ilia");
        $("[id=userEmail]").setValue("888777555444");
        $("[id=currentAddress]").setValue("г Москва, б-р Бескудниковский");
        $("[id=permanentAddress]").setValue("г. Москва Черноморский бульвар");
        $("[id=submit]").click();
    }






































}
