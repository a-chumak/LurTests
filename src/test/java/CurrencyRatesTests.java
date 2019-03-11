
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import pages.CurrencyRatesPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static libs.ConfigData.getCfgValue;
import static libs.ConfigData.ui;

@DisplayName("Check functional and content in the currency rates page")
public class CurrencyRatesTests extends BaseTests{

    CurrencyRatesPage rates = new CurrencyRatesPage();
    String iWantBuyCurrency = "EUR";
    String iWantSellCurrency = "EUR";


    @Tag("en")
    @Test
    @DisplayName("EN: User can read the text in the currency rates page")
    public void userCanSeeTextEN() {

        rates.openCurrencyRatesPage("en");
        getWebDriver().manage().window().maximize();
        $((ui("CurrencyRatesText1"))).shouldHave(exactText(getCfgValue("CarrencyIndent1EN")));
        $((ui("CurrencyRatesText2"))).shouldHave(exactText(getCfgValue("CarrencyIndent2EN")));
        System.out.println("And read text in the page");

    }

    @Tag("lv")
    @Test
    @DisplayName("LV: User can read the text in the currency rates page")
    public void userCanSeeTextLV() {

        rates.openCurrencyRatesPage("lv");
        $((ui("CurrencyRatesText1"))).shouldHave(exactText(getCfgValue("CarrencyIndent1LV")));
        $((ui("CurrencyRatesText2"))).shouldHave(exactText(getCfgValue("CarrencyIndent2LV")));
        System.out.println("And read text in the page");

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can read the text in the currency rates page")
    public void userCanSeeTextRU() {

        rates.openCurrencyRatesPage("ru");
        $((ui("CurrencyRatesText1"))).shouldHave(exactText(getCfgValue("CarrencyIndent1RU")));
        $((ui("CurrencyRatesText2"))).shouldHave(exactText(getCfgValue("CarrencyIndent2RU")));
        System.out.println("And read text in the page");

    }

    @Tag("en")
    @Test
    @DisplayName("EN: User can click on customer service centers link in the currency rates page")
    public void userCanClickOnServiceLinkEN() {

        rates.openCurrencyRatesPage("en");
        $((ui("ServiceCenterLinkEn"))).click();
        $((ui("MapsOurNetwork"))).isDisplayed();
        System.out.println("And click on 'Service center' link");

    }

    @Tag("lv")
    @Test
    @DisplayName("LV: User can click on customer service centers link in the currency rates page")
    public void userCanClickOnServiceLinkLV() {

        rates.openCurrencyRatesPage("lv");
        $((ui("ServiceCenterLinkLv"))).click();
        $((ui("MapsOurNetwork"))).isDisplayed();
        System.out.println("And click on 'Service center' link");

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can click on customer service centers link in the currency rates page")
    public void userCanClickOnServiceLinkRU() {

        rates.openCurrencyRatesPage("ru");
        $((ui("ServiceCenterLinkRu"))).click();
        $((ui("MapsOurNetwork"))).isDisplayed();
        System.out.println("And click on 'Service center' link");

    }

    @Tag("en")
    @Test
    @DisplayName("EN: User can see the actual PLN rates with '110' value")
    public void userCanSellValuePLN() {

        String iWantSellCurrency="PLN";
        String iWantSellMoney="110";

        rates.openCurrencyRatesPage("en");
        refresh();

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can see the actual USD rates with '134464.99' value")
    public void userCanSellValueUSD() {

        String iWantSellCurrency="USD";
        String iWantSellMoney="134464.99";

        rates.openCurrencyRatesPage("ru");
        refresh();

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("ru")
    @Test
    @Disabled("DEFECT: The symbol '-' is not cut off in the input")
    @DisplayName("RU: User can see the actual GBP rates with '-134.55' value")
    public void userCanSellValueGBP() {

        String iWantSellCurrency="GBP";
        String iWantSellMoney="-134.55";

        rates.openCurrencyRatesPage("ru");
        refresh();

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("en")
    @Test
    @DisplayName("EN: User can see the actual NOK rates with '0' value")
    public void userCanSellValueNOK() {

        String iWantSellCurrency="NOK";
        String iWantSellMoney="0";

        rates.openCurrencyRatesPage("en");
        refresh();

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("ru")
    @Test
    @DisplayName("RU: User can see the actual AUD rates with '123,33' value")
    public void userCanSellValueAUD() {

        String iWantSellCurrency="AUD";
        String iWantSellMoney="123,33";
        String iWantSellMoney2="12333";

        rates.openCurrencyRatesPage("ru");
        refresh();

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney2);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("random")
    @Test
    @RepeatedTest(5)
    @DisplayName("User can see the actual rates for selling with random values")
    public void userCanSellValue() {

        String iWantSellCurrency=rates.randomCurrencyAbb();
        String iWantSellMoney=rates.randomCurrencyValue();
        String locale =rates.randomLanguages();

        rates.openCurrencyRatesPage(locale);
        refresh();
        System.out.println("Page is loading with " + locale + " locale");

        $((ui("ISellSelect"))).selectOptionContainingText(iWantSellCurrency);
        $((ui("ISellInput"))).doubleClick().sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).sendKeys(Keys.BACK_SPACE);
        $((ui("ISellInput"))).setValue(iWantSellMoney);
        $((ui("IBuySelect"))).shouldHave(text(iWantBuyCurrency));

        String iBuy = rates.countIBuyValueWith(iWantSellCurrency,iWantSellMoney);
        $((ui("IBuyInput"))).shouldHave(Condition.value(iBuy));

    }

    @Tag("random")
    @Test
    @RepeatedTest(5)
    @DisplayName("User can see the actual rates for buying with random values")
    public void userCanBuyValue() {

        String iWantBuyCurrency=rates.randomCurrencyAbb();
        String iWantBuyMoney=rates.randomCurrencyValue();
        String locale =rates.randomLanguages();

        rates.openCurrencyRatesPage(locale);
        refresh();

        System.out.println("Page is loading with " + locale + " locale");

        $((ui("IBuySelect"))).selectOptionContainingText(iWantBuyCurrency);

        //doubleClick() does not work in LV page. This is the best way of many processed
        $((ui("IBuyInput"))).sendKeys(Keys.BACK_SPACE);
        $((ui("IBuyInput"))).sendKeys(Keys.BACK_SPACE);
        $((ui("IBuyInput"))).sendKeys(Keys.BACK_SPACE);
        $((ui("IBuyInput"))).sendKeys(Keys.BACK_SPACE);

        $((ui("IBuyInput"))).setValue(iWantBuyMoney);
        $((ui("ISellSelect"))).shouldHave(text(iWantSellCurrency));

        String iSell = rates.countISellValueWith(iWantBuyCurrency,iWantBuyMoney);
        $((ui("ISellInput"))).shouldHave(Condition.value(iSell));

    }

    @Test
    @DisplayName("User can see EUR reference rate value")
    public void userCanLookRefefence(){

        rates.openCurrencyRatesPage("ru");
        refresh();

        //Need to get actual rate
        Assertions.assertEquals("1.12220", rates.verifyEURReferenceRateFor("USD"));

    }


}
