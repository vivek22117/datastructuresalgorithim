package thread;

/**
 * Created by Vivek Kumar Mishra on 21/07/2018.
 */
public class PriceFinder {

    private final Currency[] currencyValues;

    public PriceFinder(){
        this.currencyValues = Currency.values();
    }

    public Price findBestPrice(Product product){
        return calculatePrice(product.getName());
    }

    private Price calculatePrice(String product) {
        Utils.randomDelay();

        double price = 10 * product.charAt(0) + product.charAt(1);
        return new Price(pickRandomCurrency(product), Utils.round(price));
    }

    private Currency pickRandomCurrency(String product) {
        return currencyValues[product.charAt(2) % currencyValues.length];
    }
}
