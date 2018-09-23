package thread;

/**
 * Created by Vivek Kumar Mishra on 04/07/2018.
 */
public class PriceCalculator {

    private Currency[] currencies;

    public PriceCalculator() {
        this.currencies = Currency.values();
    }

    public Price calculateBestPricce(Product product){
        return findBestPrice(product.getName());
    }

    private Price findBestPrice(String product) {

        Utils.randomDelay();

        double price = 10 * product.charAt(0) + product.charAt(1);

        return new Price(randomCurrencyForPrice(product), Utils.round(price));
    }

    private Currency randomCurrencyForPrice(String product) {
        return currencies[product.charAt(2) % currencies.length];
    }
}
