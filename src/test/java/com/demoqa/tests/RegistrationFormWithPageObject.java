package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomUtils;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;


public class RegistrationFormWithPageObject extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName;
    String lastName;
    String email;
    String phone;
    String day;
    String month;
    String year;
    String sex;
    String hobby;
    String address;
    String subject;

    Faker faker = new Faker();

    @BeforeEach
    void prepareTestData(){
        firstName = faker.name().firstName();
        lastName  = faker.name().lastName();
        email = faker.internet().emailAddress();
        phone = faker.phoneNumber().subscriberNumber(10);
        sex = faker.demographic().sex();
        hobby = RandomUtils.getRandomHobby();
        address = faker.address().fullAddress();
        subject = RandomUtils.getRandomSubject();
        day = String.valueOf(faker.number().numberBetween(1,28));
        month = RandomUtils.getRandomMonth();
        year = String.valueOf(faker.number().numberBetween(1980,2010));

    }

    @Test
     @Tag("choose_properties")
    @DisplayName("Заполнение формы данных по студенту на demoqa.com")
    void fillNameTest(){

    step("Заполнить форму", () -> {
                registrationFormPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setGender(sex)
                        .setNumber(phone)
                        .setBirthDate(day, month, year)
                        .setSubjects(subject)
                        .setHobbies(hobby)
                        .setPicture("img/crow.jpg")
                        .setAddress(address)
                        .setState("Haryana")
                        .setCity("Karnal")
                        .clickSubmit();
            });
    step("Открыть таблицу и сверить данные", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", sex)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", "crow.jpg")
                    .checkResult("Address", address)
                    .checkResult("State and City", "Haryana Karnal");
        });
    }
}
