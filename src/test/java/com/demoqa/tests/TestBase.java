package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //        capabilities.setCapability("browserName", "chrome");
        //        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = "https://demoqa.com";

        String browserName = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "100");
        String browserSize = System.getProperty("browserSize",  "1600x800");

        Configuration.browser= browserName;
        Configuration.browserVersion= browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.holdBrowserOpen = true;
   //     Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        if(System.getProperty("remote")!= null ){
            Configuration.remote = System.getProperty("remote");
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @AfterAll
    static void CloseBrowser(){
        closeWebDriver();
    }

}
