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
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void allFieldsTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        //Календарь
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
    void onlyWithRequiredFields() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void theNegativeScenario1() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("324421");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();

    }

    @Test
    void theNegativeScenario2() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("dfsfxdvb");
        $("[id=submit]").click();

    }

    @Test
    void theNegativeScenario3() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void theNegativeScenario4() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
    }

    @Test
    void simpleForm1() {
        open("/text-box");
        $("[id=userName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=currentAddress]").setValue("г Москва, б-р Бескудниковский");
        $("[id=permanentAddress]").setValue("г. Москва Черноморский бульвар");
        $("[id=submit]").click();
    }

    @Test
    void simpleForm2() {
        open("/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=currentAddress]").setValue("г Тверь улица тверь дом тверь");
        $("[id=permanentAddress]").setValue("г. Москва улица Кустанайская");
        $("[id=submit]").click();
    }

    @Test
    void simpleMinimumForm() {
        open("/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=submit]").click();
    }

    @Test
    void simpleFormNegative() {
        open("/text-box");
        $("[id=userName]").setValue("ilia");
        $("[id=userEmail]").setValue("888777555444");
        $("[id=currentAddress]").setValue("г Москва, б-р Бескудниковский");
        $("[id=permanentAddress]").setValue("г. Москва Черноморский бульвар");
        $("[id=submit]").click();
    }






































}
