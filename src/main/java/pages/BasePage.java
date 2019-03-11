package pages;

public class BasePage {

    public double transformStringToDouble (String value){
        return Double.parseDouble(value);
    }

    public String transformDoubleToSring (double value){
        return String.valueOf(value);
    }

    public double[] transformStringToDoubleArray(String [] rates) {


        double bankBuy = transformStringToDouble(rates[0]);
        double bankSell = transformStringToDouble(rates[1]);
        double bankReference = transformStringToDouble(rates[2]);

        return new double[] {bankBuy, bankSell, bankReference};

    }

}
