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
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();
        $("[id=dateOfBirthInput]").click();
        $("[id=dateOfBirthInput]").pressEnter();
        //Увлечение
        $("[id=subjectsInput]").setValue("Physics").pressEnter();
        $("[id=subjectsInput]").setValue("Chemistry").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        //Загрузка картинки
        $("[id=uploadPicture]").uploadFromClasspath("Screenshot_2.png");
        $("[id=currentAddress]").setValue("г. Москва Черноморский бульвар");
        // выбор города
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("[id=submit]").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-hover").shouldHave(text("ilia"));
        $(".table-hover").shouldHave(text("mir.il@mail.ru"));
        $(".table-hover").shouldHave(text("Miroshnichenko"));
        $(".table-hover").shouldHave(text("0000000000"));
        $(".table-hover").shouldHave(text("19 November,2024"));
        $(".table-hover").shouldHave(text("Sports"));
        $(".table-hover").shouldHave(text("Physics, Chemistry"));
        $(".table-hover").shouldHave(text("Screenshot_2.png"));
        $(".table-hover").shouldHave(text("г. Москва Черноморский бульвар"));
        $(".table-hover").shouldHave(text("NCR"));
        $(".table-hover").shouldHave(text("Delhi"));

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
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-hover").shouldHave(text("ilia"));
        $(".table-hover").shouldHave(text("Miroshnichenko"));
        $(".table-hover").shouldHave(text("mir.il@mail.ru"));
        $(".table-hover").shouldHave(text("0000000000"));
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
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".table-hover").shouldNotBe(visible);

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
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".table-hover").shouldNotBe(visible);

    }

    @Test
    void theNegativeScenario3() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".table-hover").shouldNotBe(visible);
    }

    @Test
    void theNegativeScenario4() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue("Miroshnichenko");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("0000000000");
        $("[id=submit]").click();
        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $(".table-hover").shouldNotBe(visible);
    }

    @Test
    void simpleForm1() {
        open("/text-box");
        $("[id=userName]").setValue("ilia");
        $("[id=userEmail]").setValue("mir.il@mail.ru");
        $("[id=currentAddress]").setValue("г Москва, б-р Бескудниковский");
        $("[id=permanentAddress]").setValue("г. Москва Черноморский бульвар");
        $("[id=submit]").click();
        $("[id=output] [id=name]").shouldHave(text("ilia"));
        $("[id=output] [id=email]").shouldHave(text("mir.il@mail.ru"));
        $("[id=output] [id=currentAddress]").shouldHave(text("г Москва, б-р Бескудниковский"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("г. Москва Черноморский бульвар"));
    }

    @Test
    void simpleForm2() {
        open("/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=currentAddress]").setValue("г Тверь улица тверь дом тверь");
        $("[id=permanentAddress]").setValue("г. Москва улица Кустанайская");
        $("[id=submit]").click();
        $("[id=output] [id=name]").shouldHave(text("Niko"));
        $("[id=output] [id=email]").shouldHave(text("mir.il2012@mail.ru"));
        $("[id=output] [id=currentAddress]").shouldHave(text("г Тверь улица тверь дом тверь"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("г. Москва улица Кустанайская"));
    }

    @Test
    void simpleMinimumForm() {
        open("/text-box");
        $("[id=userName]").setValue("Niko");
        $("[id=userEmail]").setValue("mir.il2012@mail.ru");
        $("[id=submit]").click();
        $("[id=output] [id=name]").shouldHave(text("Niko"));
        $("[id=output] [id=email]").shouldHave(text("mir.il2012@mail.ru"));
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
