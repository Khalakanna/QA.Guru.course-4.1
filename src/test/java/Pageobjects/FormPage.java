package Pageobjects;

import com.github.javafaker.Faker;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormPage {

    Faker faker = new Faker();

    String name = faker.name().firstName(),
            surname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.number().digits(10),
            gender = "Female",
            subject = "Math",
            hobby = "Music",
            address = faker.address().streetAddress(),
            state = "Haryana",
            city = "Panipat";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }
    public void fillData() {
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

    }

    public void checkData() {
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
