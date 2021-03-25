package Pageobjects.scenarios;

import Pageobjects.scenarios.FormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTests {
    Pageobjects.scenarios.FormPage FormPage = new FormPage();

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
