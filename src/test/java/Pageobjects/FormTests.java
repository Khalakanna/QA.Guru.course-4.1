package Pageobjects;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTests {
    FormPage FormPage = new FormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }
    @Test
    void successfulFormFill(){
        FormPage.openPage();
        FormPage.fillData();
        FormPage.checkData();
    }
}
