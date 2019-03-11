package pages;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.*;
import static libs.ConfigData.getCfgValue;
import static libs.ConfigData.ui;

public class MainPage {

    private static final Logger log = Logger.getLogger(MainPage.class);

    @DisplayName("Open main page")
    public void openMainPage(String language){

        switch(language)
        {
            case "en":
                open(getCfgValue("PROD_EN"));
                System.out.println("As User, I can open the main page with EN locale");
                break;
            case "lv":
                open(getCfgValue("PROD_LV"));
                System.out.println("As User, I can open the main page with LV locale");
                break;
            case "ru":
                open(getCfgValue("PROD_RU"));
                System.out.println("As User, I can open the main page with RU locale");
                break;
            default :
                open(getCfgValue("PROD"));
                System.out.println("As User, I can open the main page");
        }

    }

    @DisplayName("Click on currency rates button in the main page")
    public CurrencyRatesPage clickOnCurrencyRatesBtn(String language){

        switch(language)
        {
            case "en":
                $((ui("CurrencyRatesButtonEn"))).click();
                break;
            case "lv":
                $((ui("CurrencyRatesButtonLv"))).click();
                break;
            case "ru":
                $((ui("CurrencyRatesButtonRu"))).click();
                break;
            default :
                log.error("Currency rates button didn't find in the main page");
        }
        System.out.println("and click on 'Currency rates' button in the main page");
        return page(CurrencyRatesPage.class);
    }

    @DisplayName("Click on menu icon")
    public void clickOnMenuIcon(){

        $((ui("IconMenu"))).click();
    }

    @DisplayName("Click on currency rates link in the menu")
    public CurrencyRatesPage clickOnCurrencyRatesMenuLink(String language){

        switch(language)
        {
            case "en":
                clickOnMenuIcon();
                $((ui("CurrencyRatesLinkMenuEn"))).click();
                break;
            case "lv":
                clickOnMenuIcon();
                $((ui("CurrencyRatesLinkMenuLv"))).click();
                break;
            case "ru":
                clickOnMenuIcon();
                $((ui("CurrencyRatesLinkMenuRu"))).click();
                break;
            default :
                log.error("Currency rates link didn't find in the menu");
        }
        System.out.println("and click 'Currency rates' link in the menu");
        return page(CurrencyRatesPage.class);
    }




}
