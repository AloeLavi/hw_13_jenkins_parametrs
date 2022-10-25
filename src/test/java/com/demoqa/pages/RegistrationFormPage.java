package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {


    private final static String TITLE_TEXT = "Student Registration Form";

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();

    private StateCityComponent stateCityComponent= new StateCityComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            pictureChoice =   $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            stateSelector =  $("#state"),
            citySelector =  $("#city"),
            submitButton =   $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbies(String value){
       $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPicture(String value){
        pictureChoice.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setAddress(String value){

        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState (String value){
        stateSelector.scrollTo().click();
        stateCityComponent.Select(value);
     return this;
    }
    public RegistrationFormPage setCity (String value){
        citySelector.scrollTo().click();
        stateCityComponent.Select(value);
        return this;
    }

    public RegistrationFormPage clickSubmit (){
        submitButton.scrollTo().click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

}
