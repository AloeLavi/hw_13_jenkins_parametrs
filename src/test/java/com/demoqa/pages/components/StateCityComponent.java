package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {

    public StateCityComponent Select(String value){

        $("[id=stateCity-wrapper]").$(byText(value)).click();
        return this;
    }
}
