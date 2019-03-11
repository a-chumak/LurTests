package pages;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.*;
import static libs.ConfigData.getCfgValue;

public class CurrencyRatesPage extends BasePage{

    private static final Logger log = Logger.getLogger(CurrencyRatesPage.class);

    @DisplayName("Open currency rates page")
    public void openCurrencyRatesPage(String language) {

        switch (language) {
            case "en":
                open(getCfgValue("CurrencyRatesPageEN"));
                System.out.println("As User, I can open the currency rates with EN locale");
                break;
            case "lv":
                open(getCfgValue("CurrencyRatesPageLV"));
                System.out.println("As User, I can open the currency rates with LV locale");
                break;
            case "ru":
                open(getCfgValue("CurrencyRatesPageRU"));
                System.out.println("As User, I can open the currency rates with RU locale");
                break;
            default:
                log.error("Currency rates page hasn't loading");
        }
    }

    @DisplayName("Find the actual rates of Bank")
    public String[] findBankValueRatesFor(String currency) {

        String[] rates = new String[3];

        for (int i = 1; i <= 15; i++) {
            String sValue = null;
            sValue = $(By.xpath("//*[@id='currency-rates-table']/tr[" + i + "]/td")).getText();

            if (sValue.contains(currency)) {
                for (int j = 1; j <= 4; j++) {

                    if (j == 1) {
                        String cur = $(By.xpath("//*[@id='currency-rates-table']/tr[" + i + "]/td[" + j + "]")).getText();
                    } else if (j == 2) {
                        String bankBuys = $(By.xpath("//*[@id='currency-rates-table']/tr[" + i + "]/td[" + j + "]")).getText();
                        rates[0] = bankBuys;
                        System.out.println("I can see that Bank buys 1 EUR = " + bankBuys + " " + currency);
                    } else if (j == 3) {
                        String bankSells = $(By.xpath("//*[@id='currency-rates-table']/tr[" + i + "]/td[" + j + "]")).getText();
                        rates[1] = bankSells;
                        System.out.println("I can see that Bank sells 1 EUR = " + bankSells + " " + currency);
                    } else if (j == 4) {
                        String referenceRates = $(By.xpath("//*[@id='currency-rates-table']/tr[" + i + "]/td[" + j + "]")).getText();
                        rates[2] = referenceRates;
                        System.out.println("I can see that EUR reference rate = " + referenceRates + " " + currency);
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return (new String[]{rates[0], rates[1], rates[2]});

    }


    public String countIBuyValueWith(String currency, String sell){

        double value=transformStringToDouble(sell);

        String[] rate = findBankValueRatesFor(currency);
        double[] rates = transformStringToDoubleArray(rate);

        double bankSell = rates[1];

        double val = value/bankSell;
        double iBuy = (double) Math.round(val * 100) / 100;

        System.out.println("I can sell " + sell + " " + currency + " and get " + iBuy + " EUR");
        System.out.println();

        return transformDoubleToSring(iBuy);

    }

    public String countISellValueWith(String currency, String buy){

        double value=transformStringToDouble(buy);

        String[] rate = findBankValueRatesFor(currency);
        double[] rates = transformStringToDoubleArray(rate);

        double bankBuy = rates[0];

        double val = value/bankBuy;
        double iSell = (double) Math.round(val * 100) / 100;

        System.out.println("I can buy " + buy + " " + currency + " and get " + iSell + " EUR");
        System.out.println();

        return transformDoubleToSring(iSell);

    }

    public String verifyEURReferenceRateFor(String currency){

        String[] s = findBankValueRatesFor(currency);
        String val = s[2];
        return val;
    }

    public String randomCurrencyValue(){
        double min = 1;
        double max = 5000;
        double random = ThreadLocalRandom.current().nextDouble(min, max);
        double rnd = (double) Math.round(random * 50) / 100;
        return transformDoubleToSring(rnd);
    }

    public String randomCurrencyAbb(){
        String[] currency = {"USD","GBP","NOK","AUD","CAD","CHF","CNY","CZK","DKK","ILS","JPY","PLN","RUB","SEK","SGD"};
        int idx = new Random().nextInt(currency.length);
        return (currency[idx]);
    }

    public String randomLanguages(){
        String[] lang = {"en","lv","ru"};
        int idx = new Random().nextInt(lang.length);
        return (lang[idx]);
    }

}