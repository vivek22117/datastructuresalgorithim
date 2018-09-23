package thread.priceFinder;

import thread.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Vivek Kumar Mishra on 29/08/2018.
 */
public class FaultyPriceCalculator {

    private final Catalogue catalogue = new Catalogue();
    private final PriceFinder priceFinder = new PriceFinder();
    private final AsyncFaultyExchangeService faultyExchangeService = new AsyncFaultyExchangeService();

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        new FaultyPriceCalculator().findLocalDiscountedPrice(Currency.CHF, "Nexus 5");
    }

    private void findLocalDiscountedPrice(final Currency currency, final String productName) {
        long time = System.currentTimeMillis();

        lookUpProductByName(productName)
                .thenComposeAsync(this::findBestPrice, executorService)
                .thenCombineAsync(faultyExchangeService.lookUpExchangeRateAsyncCall(Currency.USD, currency), this::exchange)
                .thenApply(localPrice -> {
                    String output = String.format("A %s will cost us %f %s\n", productName, localPrice, currency);
                    output += String.format("It took us %d ms to calculate this\n", System.currentTimeMillis() - time);
                    return output;
                })
                .exceptionally(throwable -> "Sorry try again some time later...." + throwable.getCause().getMessage())
                .thenAccept(System.out::println);
    }

    private double exchange(Price price, double exchangeRate) {
        return Utils.round(price.getPrice() * exchangeRate);
    }

    private CompletableFuture<Price> findBestPrice(Product product) {
        return CompletableFuture.supplyAsync(() -> priceFinder.findBestPrice(product));
    }

    private CompletableFuture<Product> lookUpProductByName(String productName) {
        return CompletableFuture.supplyAsync(() -> catalogue.getProductByName(productName), executorService);
    }
}

