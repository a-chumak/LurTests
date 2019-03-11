import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static libs.ConfigData.ui;


@DisplayName("Check transitions from the main page to the currency rates page")
public class MainPageTests extends BaseTests{

    MainPage index = new MainPage();

    @Tag("en")
    @DisplayName("EN: User can open currency rates page using 'Most frequently searched' section")
    @Test
    public void userCanClickOnCRButtonEn() {

        index.openMainPage("en");
        index.clickOnCurrencyRatesBtn("en");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Currency rates"));

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can open currency rates page using 'Most frequently searched' section")
    public void userCanClickOnCRButtonRu() {

        index.openMainPage("ru");
        index.clickOnCurrencyRatesBtn("ru");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Курсы валют"));

    }

    @Tag("lv")
    @Test
    @DisplayName("LV: User can open currency rates page using 'Most frequently searched' section")
    public void userCanClickOnCRButtonLv() {

        index.openMainPage("lv");
        index.clickOnCurrencyRatesBtn("lv");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Valūtu kursi"));

    }

    @Tag("en")
    @DisplayName("EN: User can open currency rates page using menu")
    @Test
    public void userCanClickOnCRLinkEn() {

        index.openMainPage("en");
        index.clickOnCurrencyRatesMenuLink("en");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Currency rates"));

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can open currency rates page using menu")
    public void userCanClickOnCRLinkRu() {

        index.openMainPage("ru");
        index.clickOnCurrencyRatesMenuLink("ru");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Курсы валют"));

    }

    @Tag("lv")
    @Test
    @DisplayName("LV: User can open currency rates page using menu")
    public void userCanClickOnCRLinkLv() {

        index.openMainPage("lv");
        index.clickOnCurrencyRatesMenuLink("lv");
        $((ui("CurrencyRatesTitle"))).shouldHave(text("Valūtu kursi"));

    }

}
