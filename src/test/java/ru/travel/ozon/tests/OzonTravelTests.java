package ru.travel.ozon.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.travel.ozon.travel.TravelPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class OzonTravelTests extends TestBase {

    TravelPage travel = new TravelPage();

    String tickets = "билеты",
            expectedTitle = "Поиск дешевых авиа и жд билетов онлайн | купить недорого билеты на самолет и поезд: сравнение цен, расписание Ozon Travel";


    @Test
    @Description("Going from Ozon main to Ozon travel")
    @DisplayName("From main to travel")
    void fromMainToTravel() {
        step("Open 'https://www.ozon.ru'", () -> {
            travel.openOzonMain();
        });

        step("Going to Travel", () -> {
            travel.ozonTravelTab.click();
        });

        step("Make sure we are in Travel", () -> {
            travel.aviaTrainButtons.shouldHave(text(tickets));
        });
    }

    @Test
    @Description("Page title should have header text")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open 'https://www.ozon.ru'", () -> {
            travel.openOzonTravel();
        });

        step("Page title should have header text", () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Switch avia and train")
    @DisplayName("Switch avia and train")
    void switchAviaAndTrain() {
        step("Open 'https://www.ozon.ru'", () -> {
            travel.openOzonTravel();
        });

        step("Check avia text", () -> {
            travel.containerHeader.shouldHave(text("Поиск дешёвых авиабилетов"));
            travel.trainContainerHeader.shouldNotBe(visible);
        });

        step("Switch to train", () -> {
            travel.toTrainButton.click();
        });

        step("Check train text", () -> {
            travel.containerHeader.shouldHave(text("Жд билеты на поезд"));
            travel.aviaContainerHeader.shouldNotBe(visible);
        });
    }
}