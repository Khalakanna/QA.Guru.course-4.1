package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class FormFillerTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    String name = "Anna";
    String surname = "Khalak";
    String email = "Anna@anna.an";
    String gender = "Female";
    String phone = "1234567890";
    String subject = "Math";
    String hobby = "Music";
    String address = "World";
    String state = "Haryana";
    String city = "Panipat";

    @Test
    void successfulFillerTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $("[aria-label='Choose Friday, August 30th, 1991']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("testing.gif");
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".table").shouldHave(text(name),
                text(surname),
                text(email),
                text(gender),
                text(phone),
                text(hobby),
                text("30 August,1991"),
                text(subject),
                text("testing.gif"),
                text(address),
                text(state),
                text(city));
    }
}
