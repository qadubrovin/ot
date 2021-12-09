package ru.travel.ozon.travel;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TravelPage {
    //selectors
    public SelenideElement ozonTravelTab = $x("//*[@data-widget='horizontalMenu']//*[contains(text(),'Ozon Travel')]"),
            aviaTrainButtons = $x("//*[@data-widget='travelSwitchFunnels']//*[@class='ui-ac5']"),
            containerHeader = $x("//*[@data-widget='container']//h1"),
            trainContainerHeader = $x("//*[contains(text(),'Жд билеты на поезд')]"),
            toTrainButton = $x("//*[@data-widget='travelSwitchFunnels']//*[contains(text(),'ЖД билеты')]"),
            aviaContainerHeader = $x("//*[contains(text(),'Поиск дешёвых авиабилетов')]");

    //methods
    public void openOzonMain() {
        open("https://www.ozon.ru");
        $x("//*[@data-widget='loginButton']//*[@class='ui-d5']").shouldHave(text("Вход или регистрация"));
    }

    public void openOzonTravel() {
        open("https://www.ozon.ru/travel");
    }

}
